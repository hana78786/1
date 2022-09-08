package com.kh.junspring.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.junspring.board.domain.Board;
import com.kh.junspring.board.service.BoradService;

@Controller
public class BoradController {
	
	@Autowired
	BoradService bService;
	
	//게시물 등록 화면 연결
	@RequestMapping(value="/board/writeView.kh", method=RequestMethod.GET)
	public ModelAndView shoWBoardWirte(ModelAndView mv) {
		
		mv.setViewName("board/boardWriteForm");
		
		return mv;
		
		
	}
	
	//게시물 등록 코드
	@RequestMapping(value="/board/register.kh", method = RequestMethod.POST)
	public ModelAndView registBoard(ModelAndView mv,
			@ModelAttribute Board board,
			@RequestParam(value="uploadFile", required = false) MultipartFile uploadFile,
//requiered로 필수값 아닌것 표시 MultipartFile이 파일을 업로드 해주는 객체
			HttpServletRequest request
			) {
		
		
		try {
			
			
			String boardFilename = uploadFile.getOriginalFilename();
			if(!boardFilename.equals("")) {
				//만약requestParam으로 저장한 uploadfile이 비어있지 않다면
					
			
			String root= request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\buploadFiles"; //내가 저장할 폴더
			File file = new File(savePath); // 파일 객체 만들기
			
			//파일 이름으로 업로드하면 파일이름이 겹치면 파일이 겹쳐서 사라진다.
			//고유한 rename으로 변경해주어야 한다.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String boardRename = sdf.format(new Date(System.currentTimeMillis()))+"."+boardFilename.substring(boardFilename.lastIndexOf(".")+1);
			
			if(!file.exists()) { //경로에 savePath가 없을땐
				file.mkdir(); //경로 만들기
			}
			
			uploadFile.transferTo(new File(savePath+"\\"+boardRename));//파일을 buploadFile경로에 저장
			
			
			board.setBoardFile(boardFilename);
			
			String boardFilepath =savePath+"\\"+boardRename;
			
			
			board.setBoardRename(boardRename);
			board.setBoardFildpath(boardFilepath);
			
			
			}
			
			
			int result = bService.registerBoard(board);
			mv.setViewName("redirect:/board/list.kh");
			
		}catch (Exception e) {
			e.printStackTrace();
			mv.addObject("mgs",e.getMessage());
			mv.setViewName("/common/errorPage");
		}
		
		
		return mv;
	}
	
	
	
	
	//게시물 출력코드
	@RequestMapping(value="/board/list.kh", method =RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page) {
		//@RequestParam(value="page", required=false)의 값은 page이지만 
		// required=false 필수값은 아니라는 뜻
		
		int currentPage = (page != null) ? page: 1;
		//현재 페이지
		//만약 page값이 없으면 기본형 1로 출력할것, 아니면 받아온 page의 값을 준다.
		//삼항연상자 사용
		
		int totalCount = bService.getTotalCount();
		int boardLimit = 10; //한 화면에 출력할 게시물 수
		int naviLimit = 5; //한 화면에 출력할 게시판 페이지 수
		int maxPage; //게시판의 총 페이지 수
		int startNavi; //한 화면에 출력되는 게시판 페이지의 처음 수
		int endNavi;//한 화면에 출력되는 게시판 페이지의 마지막 수
		
		maxPage =(int)((double)totalCount/boardLimit+0.9);
		startNavi = ((int)((double)currentPage/naviLimit+0.9)-1)*naviLimit+1;
		endNavi=startNavi+naviLimit-1;
		
		//endNavi가 maxNavi보다 커지는 오류방지
		if(maxPage<endNavi) {
			endNavi = maxPage;
		}
		
		
		List<Board> bList = bService.printAllBoard(currentPage, boardLimit);

		if(!bList.isEmpty()) {
			mv.addObject("startNavi",startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("maxPage",  maxPage);
			mv.addObject("bList", bList);
			
		}
		
		mv.setViewName("/board/listView");
		
		return mv;
		
		
		
	}
	
	

}
