package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeModify
 */
@WebServlet("/notice/modify.do")
public class NoticeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNo = request.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		Notice notice = null;
		notice = nService.noticeDetail(noticeNo);
		if(notice!=null) {
//			성공
			request.setAttribute("notice", notice);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticemodify.jsp");
			view.forward(request, response);

			
		}else {
//			실패
			

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticefaild.html");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		int noticeNo=Integer.parseInt(request.getParameter("noticeNo"));
		String subject= request.getParameter("subject");
		String contents= request.getParameter("contents");
		NoticeService nService = new NoticeService();
		Notice notice = new Notice();
		notice.setContents(contents);
		notice.setNoticeNo(noticeNo);
		notice.setSubject(subject);
		
		int result = nService.updateNotice(notice);
		if(result==1)		{
//			RequestDispatcher view = request.getRequestDispatcher("/notice/list.do");
//			view.forward(request, response);
			
			response.sendRedirect("/notice/detaile.do?noticeNo="+noticeNo);
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("\"/WEB-INF/views/notice/noticefaild.html");
			view.forward(request, response);
			
		}
	
	}

}
