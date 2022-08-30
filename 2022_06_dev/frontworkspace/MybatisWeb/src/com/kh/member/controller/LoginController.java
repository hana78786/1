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
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("userId");
		String memberPw = request.getParameter("userPwd");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		try {
			Member mOne= new MemberServiceImpl().printMemberLogin(memberId, memberPw);
			if(mOne != null) {
			response.sendRedirect("/index.jsp");//로그인 성공하면 메인페이지로 이동
			HttpSession session = request.getSession();
			session.setAttribute("member",mOne);
			}else {
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('회원정보가 없습니다');  location.href='/index.jsp';</script>");	
			out.flush();
			out.close();
			System.out.println("로그인실패");
			
			}
			
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
		}
		
		
	}

}
