package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberServiceImpl;
import com.kh.member.vo.Member;

/**
 * Servlet implementation class MemberDetailController
 */
@WebServlet("/member/detail.do")
public class MemberDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String memberId = request.getParameter("memberId");
		Member member= new MemberServiceImpl().PrintMemberById(memberId);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/member/detail.jsp").forward(request, response);
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
		}
	}


}
