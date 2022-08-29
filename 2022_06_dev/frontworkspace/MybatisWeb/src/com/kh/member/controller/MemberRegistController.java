package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberServiceImpl;
import com.kh.member.vo.Member;

/**
 * Servlet implementation class MemberRegistController
 */
@WebServlet("/member/register.do")
public class MemberRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberRegistController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/views/member/registForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//입력받은 값안깨지게
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");//출력할 값 안깨지게
		//이 세줄을 전부 적어줘야 정상적으로 입력, 출력 한글을 인식하고 html코드를 입력가능
		
		String memberId=request.getParameter("userId");
		String memberPw=request.getParameter("userPwd");
		String memberName=request.getParameter("userName");
		String memberAddr=request.getParameter("userAddr");
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberAddress(memberAddr);
		PrintWriter out = response.getWriter();
		try {
		int result = new MemberServiceImpl().registerMember(member);
		if (result>0) {
			out.println("<script>alert('가입성공')</script>");
			out.flush();
			out.close();
		}else {
			out.println("<script>alert('가입실패')</script>");
			
		}
		}catch(Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);;
		}
	}

}
