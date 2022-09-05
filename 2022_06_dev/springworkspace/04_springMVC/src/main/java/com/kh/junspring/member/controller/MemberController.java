package com.kh.junspring.member.controller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			@RequestParam("memberName") String memberName,
			@RequestParam("memberEmail") String memberEmail,
			@RequestParam("memberPhone") String memberPhone,
			@RequestParam("post") String post,
			@RequestParam("address") String memberAddress){
		
		Member member = new Member(memberId,memberPwd,memberName,memberEmail,memberPhone,post+" , "+memberAddress);
		
		int result = mService.registerMember(member);
		if(result>0){
			
			return "redirect:/home.kh";
			
		}else {
			
		}
		
	
		return"";
	}
}
