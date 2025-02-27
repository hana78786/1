package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/notice/write.do")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//조회용
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeWrite.html");
		view.forward(request, response);

	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//저장용
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		System.out.println(subject);
		System.out.println(contents);
		
		
		//로그인한 사용자의 아이디를 가져와서 저장
		HttpSession session = request.getSession();
		String memberId =(String)session.getAttribute("memberId");
		
		System.out.println(memberId);
		
		Notice notice = new Notice();
		notice.setContents(contents);
		notice.setSubject(subject);
		notice.setMemberId(memberId);
		
		NoticeService nService = new NoticeService();
		int result=nService.insertNotice(notice);
		if(result==1) {
			response.sendRedirect("/notice/list.do");
		//	request.getRequestDispatcher("/notice/list.do");
//			.forward(request, response);
			System.out.println("쓰기성공!");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticefaild.html");
			view.forward(request, response);
		}
	}

}
