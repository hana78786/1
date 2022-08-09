package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class ModifiyServlet
 */
@WebServlet("/member/modify.do")
public class ModifiyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifiyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
	String memberPw=request.getParameter("member-pw");
	String memberEmail=request.getParameter("member-email");
	String memberPhone=request.getParameter("member-phone");
	String memberAddress=request.getParameter("member-address");
	String memberHobby=request.getParameter("member-hobby");
	String memberId=request.getParameter("member-id");
	Member member = new Member();

	
	member.setMemberPw(memberPw);
	member.setMemberEmail(memberEmail);
	member.setMemberPhone(memberPhone);
	member.setMemberAddress(memberAddress);
	member.setMemberHobby(memberHobby);
	member.setMemberId(memberId);
	
	MemberService mService = new MemberService();
	int result = mService.modify(member);
	System.out.println(memberAddress);
	
	if(result==1) {
		response.sendRedirect("/index.jsp");
		System.out.println("수정성공?");
		
	}else {
		response.sendRedirect("/Member/memberError.html");
	}

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
