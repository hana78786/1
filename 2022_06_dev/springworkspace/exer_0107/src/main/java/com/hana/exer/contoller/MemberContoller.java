package com.hana.exer.contoller;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hana.exer.doamin.Member;
import com.hana.exer.service.MemberService;


@Controller
public class MemberContoller {
	@Autowired
	MemberService mService;
	
	Sha256 sha256;
	

	private static final Logger logger = LoggerFactory.getLogger(MemberContoller.class);
	

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView indexpage(ModelAndView mv) {
		mv.setViewName("/home");
		
		return mv;
	}
	
	@RequestMapping(value="/registmember.do", method = RequestMethod.GET)
	public ModelAndView memberRegistVeiw(ModelAndView mv) {
		mv.setViewName("/member/member_regist");
		return mv;
	}
	
	@RequestMapping(value="/member/regist_info.do", method = RequestMethod.POST)
	public ModelAndView memberReist(
			ModelAndView mv, 
			@ModelAttribute Member member) {
		String newPw= sha256.testSHA256(member.getPw());
		member.setPw(newPw);
		
		int result = mService.registMember(member);
		mv.setViewName("redirect:/login.do");
		
		return mv;
		
	}
	
	

	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView memberLoginView(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
		
	}
	
	@RequestMapping(value="/loginout.do", method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView mv,  HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		mv.setViewName("redirect:/login.do");
		return mv;
		
	}
	
	@RequestMapping(value="/loginMember.do", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, @ModelAttribute Member member, HttpServletRequest request) {		
		member.setPw(sha256.testSHA256(member.getPw()));
		Member loginMember = mService.loginMember(member);
		if(loginMember == null) {
			mv.addObject("msg", "loginEror");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			mv.addObject("Member",loginMember);
		}

		
		mv.setViewName("/member/login");
		
		return mv;
		
	}
	
}