package com.hana.exer.contoller;

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
	
	

	private static final Logger logger = LoggerFactory.getLogger(MemberContoller.class);
	

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView indexpage(ModelAndView mv) {
		mv.setViewName("/home");
		
		return mv;
	}
	
	@RequestMapping(value="/registmember.do", method = RequestMethod.GET)
	public ModelAndView memberRegistVeiw(ModelAndView mv) {
		logger.info("회원가입 컨트롤러 진입");
		mv.setViewName("/member/member_regist");
		return mv;
	}
	
	@RequestMapping(value="/member/regist_info.do", method = RequestMethod.POST)
	public ModelAndView memberReist(
			ModelAndView mv, 
			@ModelAttribute Member member) {
		
		int result = mService.registMember(member);
		
		return mv;
		
	}
	
}