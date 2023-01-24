package com.hana.exer.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView registFreeView(ModelAndView mv, HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		if(member==null) {
			mv.setViewName("redirect:/login.do");
		}else {
			mv.setViewName("/bbs/registbbs");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/registfree.do",method = RequestMethod.POST)
	public ModelAndView registFree(ModelAndView mv, HttpSession session
			,@ModelAttribute Bbs bbs) {
		Member member = (Member)session.getAttribute("loginMember");
		if(member==null) {
			mv.setViewName("redirect:/login.do");
		}else {
			bbs.setName(member.getName());
		int result = bService.resgitBbs(bbs);
		mv.setViewName("redirct:/bbsList.do");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/readbbs.do",method = RequestMethod.GET)
	public ModelAndView readbbs(ModelAndView mv, HttpSession session
			,@RequestParam int bbsNo
		) {
		Member member = (Member)session.getAttribute("loginMember");
		if(member==null) {
			mv.setViewName("redirect:/login.do");
		}else {
			Bbs bbs = bService.readBbsOne(bbsNo);
			mv.addObject("bbs", bbs);
		mv.setViewName("/bbs/readbbs");
		}
		return mv;
	}
	
	@RequestMapping(value="/freemodifyview.do",method = RequestMethod.GET)
	public ModelAndView freemodifyview(ModelAndView mv, HttpSession session
			,@RequestParam int bbsNo
			) {
		Member member = (Member)session.getAttribute("loginMember");
		if(member==null) {
			mv.setViewName("redirect:/login.do");
		}else {
			Bbs bbs = bService.readBbsOne(bbsNo);
			mv.addObject("bbs", bbs);
			mv.setViewName("/bbs/modifybbs");
		}
		return mv;
	}
	@RequestMapping(value="/freemodify.do",method = RequestMethod.POST)
	public ModelAndView freemodify(ModelAndView mv, HttpSession session
			,@ModelAttribute Bbs bbs
			) {
		Member member = (Member)session.getAttribute("loginMember");
		if(member==null) {
			mv.setViewName("redirect:/login.do");
		}else {
			int result = bService.checkName(member.getName());
			if(result==0) {
				mv.setViewName("redirect:/login.do");
			}else {
				int result1 = bService.modifyOneBBs(bbs); 
				mv.addObject("bbsNo", bbs.getBbsNo());
				mv.setViewName("redirect:/readbbs.do");
			}
			
		}
		return mv;
	}
	
	
}
