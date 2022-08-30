package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberServiceImpl;
import com.kh.member.vo.Member;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/member/list.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceImpl mService = new MemberServiceImpl();
		ArrayList<Member> mList = mService.printMemberList();
	if(!mList.isEmpty()) {
		request.setAttribute("members", mList);
		request.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(request, response);
	}else {
		
		request.setAttribute("msg", "fail");
		request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
		
		
	}
	}


}
