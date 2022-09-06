package com.kh.junspring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.junspring.member.domain.Member;
import com.kh.junspring.member.service.MemberService;
import com.kh.junspring.member.service.logic.MemberServicImpl;

//스프링에서 동작하게 하기 위해 반드시 적어야 한다.
@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	
	@RequestMapping(value="/member/joinView.kh", method=RequestMethod.GET)
	public String memberJoinView() {
		
		return "member/join";
		//이름.jsp의 이름을 return으로 만든다
		//이름의 주소를 파악하여 연결한다.
		//WEB-INF/views/member/join.jsp
	}
	
	@RequestMapping(value = "/member/register.kh", method=RequestMethod.POST)
	public String memberJoin(
			@ModelAttribute Member member,
//			이 변수를 member변수에 한번으로 저장하려면 input name값이 domain의 변수명과 일치해야 한다.
//			일치하지 않는 경우에는 그것만 빼고 1같이 쓴다.			
//			@RequestParam("memberId") String memberId,
//			@RequestParam("memberPw") String memberPw,
//			@RequestParam("memberName") String memberName,
//			@RequestParam("memberEmail") String memberEmail,
//			@RequestParam("memberPhone") String memberPhone,
			@RequestParam("post") String post,
			@RequestParam("address") String memberAddress,
			Model model
			){
		//폼태그에 있는 name값을 ("")안에 자료형 변수명은 값을 변수명에 초기화
		
//		Member member = new Member(memberId,memberPw,memberName,memberEmail,memberPhone,post+" , "+memberAddress);
	
		//1
		member.setMemberAddress(post+","+memberAddress);
		
		try {
		int result = mService.registerMember(member);
		if(result>0){
			
			return "redirect:/home.kh";
			
		}else {
			model.addAttribute("msg","회원가입 실패");
			return "common/errorPage";
			
		}}catch(Exception e){
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
			
		}
		
	
	}
	
	
	
	@RequestMapping(value = "/member/login.kh", method=RequestMethod.POST)
	public String memberLogin(
			@ModelAttribute Member member,
//			@RequestParam("memberId") String memberId,
//			@RequestParam("memberPw") String memberPw
			HttpServletRequest request, //세션값 주기위해 서블렛 선언하기
			Model model //request를 대체함
			) {
		//Member member = new Member(memberId, memberPw);

		
		try {
		Member loginUser = mService.loginMember(member);
		
		if(loginUser != null) {
			HttpSession session = request.getSession(); //세션저장하기
			session.setAttribute("loginUser", loginUser); //세션을 loginUser로 전송하기

			return "redirect:/home.kh";
			}else {
			model.addAttribute("msg","회원정보 없음");
			return"common/errorPage";
		}
		}catch(Exception e) {
			
			model.addAttribute("msg",e.getMessage());//requestSetAttribute와 같음

		return"common/errorPage";
		}
		
	}
	
	
	@RequestMapping(value = "/member/logout.kh", method=RequestMethod.GET)
	public String memberLogout(
			HttpServletRequest request,
			Model model
			) {
		HttpSession session = request.getSession();
		if(session!=null) {
			session.invalidate();
			return "redirect:/home.kh";
		}else{
			model.addAttribute("mgs", "로그아웃 실패");
		}
		
		return "";
	}
	
	@RequestMapping(value="/member/myPage.kh", method=RequestMethod.GET)
	public String viewMyPage() {
		
		
		return "member/myPage";
	}

}
