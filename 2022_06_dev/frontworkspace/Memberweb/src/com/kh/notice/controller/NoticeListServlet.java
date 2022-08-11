package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.model.vo.PageData;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/list.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      respone)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService nService = new NoticeService();
		ArrayList<Notice> nList = null;
		PageData pd = null;
		int currentpage = 1;
		if (request.getParameter("currentPage") != null) {
			currentpage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		pd = nService.noticeList(currentpage);
		nList = pd.getnList();
		String pageNavi= pd.getPageNavi();
		
		if (!nList.isEmpty()) {
			// 성공
			System.out.println("여기는 리스트 서블릿");

			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
			view.forward(request, response);

		} else {
			// 실패
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticefaild.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
