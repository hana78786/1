package com.hana.exer.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hana.exer.doamin.Bbs;
import com.hana.exer.doamin.Member;
import com.hana.exer.service.BbsSerivce;

@Controller
public class BbsController {
	@Autowired
	BbsSerivce bService;
	
	@RequestMapping(value="/bbsList.do",method = RequestMethod.GET)
	public ModelAndView bbsList(ModelAndView mv) {
		List<Bbs> bList = bService.bbsTitle();
		mv.addObject("bbslist", bList);
		mv.setViewName("/bbs/freebbs");
		return mv;
		
	}

	@RequestMapping(value="/registfree.do",method = RequestMethod.GET)
	public ModelAndView registFree(ModelAndView mv, HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		if(member==null) {
			mv.setViewName("redirect:/login.do");
		}else {
		mv.setViewName("/bbs/registbbs");
		}
		return mv;
	}
}
