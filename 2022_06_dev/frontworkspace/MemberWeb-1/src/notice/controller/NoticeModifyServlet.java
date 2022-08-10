package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.vo.Notice;
import notice.service.NoticeService;

/**
 * Servlet implementation class NoticeModify
 */
@WebServlet("/notice/modify.do")
public class NoticeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int noticeNo=Integer.parseInt(request.getParameter("noticeNo"));
	NoticeService nServide = new NoticeService();
	
	Notice notice = null;

	notice = nServide.noticeDetail(noticeNo);
	if(notice!=null) {
		request.setAttribute("notice", notice);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticeModify.jsp");
				view.forward(request, response);
		
	}
	else {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticeError.jsp");
		view.forward(request, response);
		
		
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int noticeNo=Integer.parseInt(request.getParameter("noticeNo"));
		String subject=request.getParameter("subject");
		String contents=request.getParameter("contents");
		
		NoticeService nService = new NoticeService();
		Notice notice = new Notice();
		
		notice.setNoticeNo(noticeNo);
		notice.setSubject(subject);
		notice.setcontents(contents);
		
		int result = nService.NoticeModify(notice);
		if(result==1) {
		 response.sendRedirect("/notice/detail.do?noticeNo="+noticeNo);	
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticeError.jsp");
			view.forward(request, response);
		}
		
		
	}

}
