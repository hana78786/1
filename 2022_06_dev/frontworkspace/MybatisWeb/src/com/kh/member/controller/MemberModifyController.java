package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.service.MemberServiceImpl;
import com.kh.member.vo.Member;

/**
 * Servlet implementation class MemberModifyController
 */
@WebServlet("/member/modify.do")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Member mOne = (Member)session.getAttribute("member");
		String memberId=mOne.getMemberId();
		Member member = new MemberServiceImpl().PrintMemberById(memberId);
		request.setAttribute("member",member);
		request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
		System.out.println(member.getMemberPw());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //입력받은 한글 깨지지 않도록
		String memberPw = request.getParameter("userPwd");
		String memberAddress  = request.getParameter("userAddr"); 
		String memberId = request.getParameter("userId");
		Member mOne=new Member();
		mOne.setMemberPw(memberPw);
		mOne.setMemberAddress(memberAddress);
		mOne.setMemberId(memberId);
		
		
		//update member_tbl set member_pw=#{memberPw}, member_address=#{memberAddress} where member_id = 
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
		int result= new MemberServiceImpl().updateMember(mOne);
		if(result>0) {//성공시 정보수정이 완료되었습니다 출력 후 리스트로 이동
			PrintWriter out = response.getWriter();
			out.print("<script>alert('정보수정이 완료되었습니다'); location.href='/member/list.do'</script>");
			out.flush();
			out.close();
			
		}
		}catch(Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);;
		}
	}

}
