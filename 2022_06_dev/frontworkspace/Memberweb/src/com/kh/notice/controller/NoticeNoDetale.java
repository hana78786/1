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
 * Servlet implementation class NoticeNoDetale
 */
@WebServlet("/notice/detaile.do")
public class NoticeNoDetale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeNoDetale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		System.out.println("디테일서블릿 시작");
		
		
		String noticeNo = request.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		Notice notice = null;
		notice = nService.noticeDetail(noticeNo);
		if(notice!=null) {
//			성공
			request.setAttribute("notice", notice);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticedetail.jsp");
			view.forward(request, response);
			System.out.println("여기는 디테일 서블릿");

			
		}else {
//			실패
			

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticefaild.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
