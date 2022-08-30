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
 * Servlet implementation class MemberDeleteController
 */
@WebServlet(name = "/member/delete.do", urlPatterns = { "/member/delete.do" })
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		String memberId=member.getMemberId();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		try {
			int result = new MemberServiceImpl().deleteMember(memberId);
			if(result>0) {
				PrintWriter out = response.getWriter();
				out.print("<script>alert('회원탈퇴 완료');location.href='/member/logout.do';</script>");
				
				
				
			}
						
		}catch(Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
		}
		
		

	

}
}
