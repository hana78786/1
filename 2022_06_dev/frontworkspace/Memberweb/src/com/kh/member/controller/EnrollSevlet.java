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
 * Servlet implementation class EnrollSevlet
 */
@WebServlet("/member/enroll.do")
public class EnrollSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberService();
		request.setCharacterEncoding("utf-8");
		String memberId =request.getParameter("member-id");
		String memberPw=request.getParameter("member-pw");
		String memberName=request.getParameter("member-name");
		int memberAge=Integer.parseInt(request.getParameter("member-age"));
		String memberEmail=request.getParameter("member-email");
		String memberPhone=request.getParameter("member-phone");
		String memberAddress=request.getParameter("member-address");
		char memberGender=request.getParameter("gender").charAt(0);
		String memberHobby=request.getParameter("member-hobby");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setMemberAge(memberAge);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberGender(memberGender);
		member.setMemberHobby(memberHobby);
		
		int result=memberService.insertMember(member);
		
		if(result>0) {
			response.sendRedirect("/index.jsp");
			
			
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
