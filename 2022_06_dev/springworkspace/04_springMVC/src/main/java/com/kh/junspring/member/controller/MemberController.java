package com.kh.junspring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.junspring.member.domain.Member;
import com.kh.junspring.member.service.MemberService;
import com.kh.junspring.member.service.logic.MemberServicImpl;

//스프링에서 동작하게 하기 위해 반드시 적어야 한다.
@Controller
public class MemberController {
	@Autowired
	private MemberService mService;

	@RequestMapping(value = "/member/joinView.kh", method = RequestMethod.GET)
	public String memberJoinView() {

		return "member/join";
		// 이름.jsp의 이름을 return으로 만든다
		// 이름의 주소를 파악하여 연결한다.
		// WEB-INF/views/member/join.jsp
	}

	@RequestMapping(value = "/member/register.kh", method = RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute Member member, @RequestParam("post") String post,
			@RequestParam("address") String memberAddress,
			// Model model,
			ModelAndView mv) {

		member.setMemberAddress(post + "," + memberAddress);

		try {
			int result = mService.registerMember(member);
			if (result > 0) {

//				return "redirect:/home.kh";
				mv.setViewName("redirect:/home.kh");
			} else {
//				model.addAttribute("msg", "회원가입 실패");
//				return "common/errorPage";
				mv.addObject("msg", "회원가입 실패");
				mv.setViewName("common/errorPage");

			}
		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			return "common/errorPage";

			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");

		}
		return mv;

	}

	@RequestMapping(value = "/member/login.kh", method = RequestMethod.POST)
	public ModelAndView memberLogin(@ModelAttribute Member member,
//			@RequestParam("memberId") String memberId,
//			@RequestParam("memberPw") String memberPw
			HttpServletRequest request, // 세션값 주기위해 서블렛 선언하기
			// Model model // request를 대체함
			ModelAndView mv) {
		// Member member = new Member(memberId, memberPw);

		try {
			Member loginUser = mService.loginMember(member);

			if (loginUser != null) {
				HttpSession session = request.getSession(); // 세션저장하기
				session.setAttribute("loginUser", loginUser); // 세션을 loginUser로 전송하기
				mv.setViewName("redirect:/home.kh");
				// return "redirect:/home.kh";
			} else {
				// model.addAttribute("msg", "회원정보 없음");
				// return "common/errorPage";

				mv.addObject("msg", "회원정보 없음");
				mv.setViewName("common/errorPage");

			}
		} catch (Exception e) {

			// model.addAttribute("msg", e.getMessage());// requestSetAttribute와 같음

			// return "common/errorPage";

			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}

		return mv;

	}

	@RequestMapping(value = "/member/myPage.kh", method = RequestMethod.GET)
	public ModelAndView viewMyPage(HttpServletRequest request,

			// Model model
			ModelAndView mv) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		Member mOne = mService.printOneById(memberId);
		String post = mOne.getMemberAddress().split(",")[0];
		String address = mOne.getMemberAddress().split(",")[1];
		// String[] address mOne.getMemberAddress().split(",")
		// model.addAttribute("address",address);로 전송하여

		try {

//			model.addAttribute("member", mOne);
//			model.addAttribute("post", post);
//			model.addAttribute("address", address);

			mv.addObject("member", mOne);
			mv.addObject("post", post);
			mv.addObject("address", address);
			mv.setViewName("member/myPage");
			// return "member/myPage";
		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
			// return "common/errorPage";
		}
		return mv;
	}

	@RequestMapping(value = "/member/logout.kh", method = RequestMethod.GET)
	public ModelAndView memberLogout(HttpServletRequest request, 
//			Model model
			ModelAndView mv
			) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
//			return "redirect:/home.kh";
			mv.setViewName("redirect:/home.kh");
		} else {
//			model.addAttribute("mgs", "로그아웃 실패");
//		return "common/errorPage";
			mv.addObject("mgs", "로그아웃 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	@RequestMapping(value = "/member/modify.kh", method = RequestMethod.POST)
	public ModelAndView memberModify(@ModelAttribute Member member, @RequestParam("post") String post,
			@RequestParam("address") String address,
//			Model model
			ModelAndView mv
			) {

		try {
			member.setMemberAddress(post + "," + address);
			int result = mService.modifyMember(member);
			if (result == 1) {

//				return "redirect:/home.kh";
				mv.setViewName("redirect:/home.kh");

			} else {
//				model.addAttribute("msg", "회원수정 실패");
//				return "common/errorPage";
				
				mv.addObject("msg","회원 수정 실패");
				mv.setViewName("common/erroPage");
			}

		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			return "common/errorPage";
			
			mv.addObject("msg",e.getMessage());
			mv.setViewName("common/erroPage");
		}
		
		return mv;

	}

	@RequestMapping(value = "/member/remove.kh", method = RequestMethod.GET)
	// 버튼을 통해 넘어왔기에 무조건 get post는 폼에서 post를 지정해줘야만 가능하다
	public ModelAndView removeMember(HttpSession session, 
//			Model model
			ModelAndView mv
			) {

		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();

		try {
			int result = mService.removeMember(memberId);

			if (result == 1) {
//				return "redirect:/member/logout.kh";
				
				mv.setViewName("redirect:/member/logout.kh");
			}

		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			return "common/errorPage";
			mv.addObject("msg", e.getMessage());
			mv.setViewName("common/errorPage");
		}

//		return "common/errorPage";
		return mv;
	}

}
