package com.kh.exproject.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.exproject.domain.Member;
import com.kh.exproject.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService mService;
	
	
	@RequestMapping(value="/member/join.kh", method = RequestMethod.GET)
	public ModelAndView joinView(ModelAndView mv) {
		
		mv.setViewName("member/join");
		
		
		return mv;
	}
	
	@RequestMapping(value="/member/register.kh", method = RequestMethod.POST)
	public ModelAndView registerMember(
			@ModelAttribute Member member,
			ModelAndView mv,
			@RequestParam("post") String post,
			@RequestParam("address") String address
			
			) {
		member.setAddress(post+","+address);
		int result = mService.registerMember(member);
		
		
		return mv;
		
	}

}
