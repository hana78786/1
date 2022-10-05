package com.kh.junspring.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.ibatis.executor.ReuseExecutor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.domain.Reply;
import com.kh.junspring.board.service.BoradService;
import com.kh.junspring.member.domain.Member;

@Controller
public class BoradController {

	@Autowired
	BoradService bService;

	/***
	 * 게시물 등록화면 연결
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/board/writeView.kh", method = RequestMethod.GET)
	public ModelAndView shoWBoardWirte(ModelAndView mv) {

		mv.setViewName("board/boardWriteForm");

		return mv;

	}

	/**
	 * 게시물 수정화면 연결
	 * 
	 * @param mv
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value = "/board/modifyView.kh", method = RequestMethod.GET)
	public ModelAndView boardModifyView(ModelAndView mv, @RequestParam("boardNo") Integer boardNo,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchValue", required = false) String searchValue,
			@RequestParam(value = "page", required = false) String pageNow) {
		try {
			Board board = bService.printOneVyNo(boardNo);
			if (board != null) {

				mv.addObject("board", board);
				mv.addObject("searchValue", searchValue);
				mv.addObject("searchCondition", searchCondition);
				mv.addObject("pageNow", pageNow);
				mv.setViewName("board/modifyForm");
			}

		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("mgs", e.getMessage());
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}

	/**
	 * 게시물 등록
	 * 
	 * @param mv
	 * @param board
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/board/register.kh", method = RequestMethod.POST)
	public ModelAndView registBoard(ModelAndView mv, @ModelAttribute Board board,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
//requiered로 필수값 아닌것 표시 MultipartFile이 파일을 업로드 해주는 객체
			HttpServletRequest request) {

		try {

			String boardFilename = uploadFile.getOriginalFilename();
			if (!boardFilename.equals("")) {
				// 만약requestParam으로 저장한 uploadfile이 비어있지 않다면

				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\buploadFiles"; // 내가 저장할 폴더
				File file = new File(savePath); // 파일 객체 만들기

				// 파일 이름으로 업로드하면 파일이름이 겹치면 파일이 겹쳐서 사라진다.
				// 고유한 rename으로 변경해주어야 한다.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String boardRename = sdf.format(new Date(System.currentTimeMillis())) + "."
						+ boardFilename.substring(boardFilename.lastIndexOf(".") + 1);

				if (!file.exists()) { // 경로에 savePath가 없을땐
					file.mkdir(); // 경로 만들기
				}

				uploadFile.transferTo(new File(savePath + "\\" + boardRename));// 파일을 buploadFile경로에 저장

				board.setBoardFile(boardFilename);

				String boardFilepath = savePath + "\\" + boardRename;

				board.setBoardRename(boardRename);
				board.setBoardFildpath(boardFilepath);

			}

			int result = bService.registerBoard(board);
			mv.setViewName("redirect:/board/list.kh");

		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("mgs", e.getMessage());
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}

	/**
	 * 게시글 수정
	 * 
	 * @param mv
	 * @param board
	 * @return
	 */
	@RequestMapping(value = "/board/modify.kh", method = RequestMethod.POST)
	public ModelAndView modifyBoard(ModelAndView mv, @ModelAttribute Board board,
			@RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchValue", required = false) String searchValue,
			@RequestParam(value = "page", required = false) String pageNow, HttpServletRequest request) {
		try {
			String boardFilename = reloadFile.getOriginalFilename();
			if (reloadFile != null && !boardFilename.equals(""))// 새로 파일을 올렸을때, 이름이 없는 파일이 있을 경우를 생각해 null체크 2번함
			{// 수정 할경우 대체/ 삭제 후 등록/ 대체는 어려워서 삭제후 등록으로 한다
				String root = request.getSession().getServletContext().getRealPath("resources");// 저장된 파일의 경로를 가져온다.
				String savedPath = root + "\\buploadFiles"; // 가져온 경로에 업로드 파일이 들어있는 폴더의 경로까지 더해줌
				System.out.println(board.getBoardRename());
				File file = new File(savedPath + "\\" + board.getBoardRename()); // 이미 저장한 파일의 이름을 가져와야 한다.
				if (file.exists()) { // 지정한 파일이 있는지 없는지 체크
					file.delete(); // 있으면 삭제
				}

				////////// 여기부터 파일 재 업로드/////////////////////
				// 파일 이름으로 업로드하면 파일이름이 겹치면 파일이 겹쳐서 사라진다.
				// 고유한 rename으로 변경해주어야 한다.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String boardRename = sdf.format(new Date(System.currentTimeMillis())) + "."
						+ boardFilename.substring(boardFilename.lastIndexOf(".") + 1);

				reloadFile.transferTo(new File(savedPath + "\\" + boardRename));
				board.setBoardFile(boardFilename);
				board.setBoardRename(boardRename);
				board.setBoardFildpath(savedPath + "\\" + boardRename);

			}

			String eValue = URLEncoder.encode(searchValue, "UTF-8");

			int result = bService.modifyBoardOneByNo(board);
			if (searchValue.equals("") || searchValue.isEmpty()) {
				mv.setViewName("redirect:/board/detail.kh?boardNo=" + board.getBoardNo() + "&page=" + pageNow);
			} else {
				mv.setViewName("redirect:/board/detail.kh?boardNo=" + board.getBoardNo() + "&searchCondition="
						+ searchCondition + "&searchValue=" + eValue + "&page=" + pageNow);

			}

		} catch (Exception e) {
			mv.addObject("mgs", e.getMessage());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}

	/**
	 * 게시물 리스트
	 * 
	 * @param mv
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/board/list.kh", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
			HttpSession session) {
		// @RequestParam(value="page", required=false)의 값은 page이지만
		// required=false 필수값은 아니라는 뜻

		int currentPage = (page != null) ? page : 1;
		// 현재 페이지
		// 만약 page값이 없으면 기본형 1로 출력할것, 아니면 받아온 page의 값을 준다.
		// 삼항연상자 사용

		int totalCount = bService.getTotalCount("", "");
		int boardLimit = 10; // 한 화면에 출력할 게시물 수
		int naviLimit = 5; // 한 화면에 출력할 게시판 페이지 수
		int maxPage; // 게시판의 총 페이지 수
		int startNavi; // 한 화면에 출력되는 게시판 페이지의 처음 수
		int endNavi;// 한 화면에 출력되는 게시판 페이지의 마지막 수

		maxPage = (int) ((double) totalCount / boardLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;

		// endNavi가 maxNavi보다 커지는 오류방지
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}

		List<Board> bList = bService.printAllBoard(currentPage, boardLimit);

		if (!bList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("bList", bList);

		}

		mv.addObject("pageNow", currentPage);
		mv.setViewName("/board/listView");

		return mv;

	}

	/**
	 * 게시물 검색
	 * 
	 * @param mv
	 * @param searchCondition
	 * @param searchValue
	 * @return
	 */
	@RequestMapping(value = "/board/search.kh", method = RequestMethod.GET)
	public ModelAndView boardSearchList(ModelAndView mv, @RequestParam("searchCondition") String searchCondition,
			@RequestParam(value = "page", required = false) Integer page, // 페이징을 위한 매개변수
			@RequestParam("searchValue") String searchValue, HttpSession session) {
		try {

			///////////////////////////////// 페이징시작//////////////////////////////
			int currentPage = (page != null) ? page : 1;
			int boardLimit = 10; // 한 화면에 출력할 게시물 수
			///// 페이징용////

			List<Board> bList = bService.printAllByValue(searchCondition, searchValue, currentPage, boardLimit);

			if (!bList.isEmpty()) {

				mv.addObject("bList", bList);

			} else {
				mv.addObject("bList", null);

			}

			///// 페이징용////
			int totalCount = bService.getTotalCount(searchCondition, searchValue);

			int naviLimit = 5; // 한 화면에 출력할 게시판 페이지 수
			int maxPage; // 게시판의 총 페이지 수
			int startNavi; // 한 화면에 출력되는 게시판 페이지의 처음 수
			int endNavi;// 한 화면에 출력되는 게시판 페이지의 마지막 수

			maxPage = (int) ((double) totalCount / boardLimit + 0.9);
			startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
			endNavi = startNavi + naviLimit - 1;

			// endNavi가 maxNavi보다 커지는 오류방지
			if (maxPage < endNavi) {
				endNavi = maxPage;
			}

			mv.addObject("urlVal", "search");
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("maxPage", maxPage);
			//////////////////////////////// 페이징종료///////////////////////////////////

			mv.addObject("pageNow", currentPage);
			mv.addObject("searchValue", searchValue);
			mv.addObject("searchCondition", searchCondition);
			mv.setViewName("board/listView");

		} catch (Exception e) {

			mv.addObject("msg", e.getMessage()).setViewName("/common/errorPage");

		}

		// 쿼리문 select * from board_tbl where b_status = 'Y' and board_title like
		// '%'||#{searchValue}||'%';

		return mv;
	}

	/**
	 * 게시물 상세보기
	 * 
	 * @param mv
	 * @param boardNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/board/detail.kh", method = RequestMethod.GET)
	public ModelAndView boardDetailView(ModelAndView mv, @RequestParam("boardNo") Integer boardNo,
			@RequestParam(value = "searchCondition", required = false) String searchCondition,
			@RequestParam(value = "searchValue", required = false) String searchValue,
			@RequestParam(value = "page", required = false) String pageNow, HttpSession session) {

		if (boardNo != null) {
			Board board = bService.printOneVyNo(boardNo);
			List<Reply> rList = bService.PrintAllReply(boardNo);

			session.setAttribute("boardNo", boardNo); // 세션에 boardNo가 추가된다, 현재 가지고 있는 세션은 유지된다.
			try {
				mv.addObject("board", board);
				mv.addObject("searchCondition", searchCondition);
				mv.addObject("searchValue", searchValue);
				mv.addObject("pageNow", pageNow);

				if (rList.size() > 0) { // 이거 안해줬더니 nullpoint떴음....
					mv.addObject("rList", rList);
				}
				mv.setViewName("/board/detail");

			} catch (Exception e) {
				mv.addObject("mgs", e.getMessage());
				mv.setViewName("/common/errorPage");
			}

		} else {
			mv.addObject("msg", "게시물 선택 오류");
			mv.setViewName("/common/errorPage");
		}

		return mv;
	}

	/**
	 * 게시물 삭제
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "board/remove.kh", method = RequestMethod.GET)
	public String boardReomve(HttpSession session, Model model,
			@RequestParam(value = "page", required = false) String pageNow

	) {

		try {
			int boardNo = (int) session.getAttribute("boardNo");

			int result = bService.removeOneByNo(boardNo);
			if (result > 0) {
				session.removeAttribute("boardNo"); // 한가지의 세션만 지운다.
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "/common/errorPage";
		}
		String dierctPage = "redirect:/board/list.kh?page=" + pageNow;
		return dierctPage;

	}

	// 댓글관리
	/**
	 * 댓글등록
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/board/addReply.kh", method = RequestMethod.POST)
	public ModelAndView addBoardReply(ModelAndView mv, @ModelAttribute Reply reply, HttpSession session) {

		Member member = (Member) session.getAttribute("loginUser");
		String replyWriter = member.getMemberId();
		reply.setReplyWirter(replyWriter);
		int result = bService.registerReply(reply);
		// insert into reply_tbl values(#{relplyNo}, #{refBoardNo}, #{replyContents},
		// #{replyWirter},
		// #{rCreateDate}, #{rUpdateDate}, #{rStatus}
		try {
			int boardNo = reply.getRefBoardNo();
			mv.setViewName("redirect:/board/detail.kh?boardNo=" + boardNo);
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("/common/errorPage");
		}
		return mv;

	}

	/**
	 * 댓글수정
	 * 
	 * @param mv
	 * @param reply
	 * @return
	 */
	@RequestMapping(value = "/board/modifireply.do", method = RequestMethod.POST)
	public ModelAndView modifyReply(ModelAndView mv, @RequestParam("replyContents") String replyContents, @RequestParam("replyNo") int replyNo, HttpSession session) {
		
		try {
			Reply reply = new Reply();
			reply.setReplyContents(replyContents);
			reply.setReplyNo(replyNo);
			int result = bService.modifyReply(reply);
			int boardNo = reply.getRefBoardNo();
			mv.setViewName("redirect:/board/detail.kh?boardNo=" + boardNo);
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("/common/errorPage");
		}
		return mv;
	}

	/**
	 * 댓글삭제
	 * 
	 * @param mv
	 * @param replyNo
	 * @param replyWriter
	 * @param boardNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/board/removeReply.kh")
	public ModelAndView removeReply(ModelAndView mv, @RequestParam("replyNo") String replyNo,
			@RequestParam("replyWirter") String replyWriter, @RequestParam("boardNo") String boardNo,
			HttpSession session) {

		Member member = (Member) session.getAttribute("loginUser");

		if (!replyWriter.equals((member.getMemberId()))) {
			mv.addObject("msg", "작성자가 아니면 삭제할수 없습니다.");
			mv.setViewName("/common/errorPage");
			return mv;
		}
		try {
			int result = bService.removeReply(replyNo);
			mv.setViewName("redirect:/board/detail.kh?boardNo=" + boardNo);
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("/common/errorPage");

		}

		return mv;
	}

	@ResponseBody // 이걸 자꾸 빼먹는다!!! 꼭 기억할 것!
	@RequestMapping(value = "/board/replyAdd.kh", method = RequestMethod.POST)
	public String boardReplyAdd(@ModelAttribute Reply reply) {
		reply.setReplyWirter("admin");
		int result = bService.registerReply(reply);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}

	}

	
	@ResponseBody
	@RequestMapping(value = "/board/replyList.kh", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String boardReplyList(@RequestParam("boardNo") int boardNo) {
		int bno = (boardNo == 0) ? 1 : boardNo;
		List<Reply> rList = bService.PrintAllReply(bno);
		if (!rList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			return gson.toJson(rList);

		}

		return null;

	}
	
	/** 댓글 하나 불러오기*/
	@ResponseBody
	@RequestMapping(value = "/board/replyModi.kh", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String selectOneReply(@RequestParam("replyNo") int replyNo) {
		Reply reply = bService.printOneReply(replyNo);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("rContents",reply.getReplyContents());
		
		
		return jsonObj.toString();

	}

}
