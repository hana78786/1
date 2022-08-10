package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.vo.Notice;
import notice.service.NoticeService;

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
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticewrite.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		
		NoticeService nService = new NoticeService();
		HttpSession session = request.getSession();
		String memberId= (String)session.getAttribute("memberId");
		System.out.println((String)session.getAttribute("memberId"));
		
		Notice notice = new Notice();
		notice.setcontents(contents);
		notice.setMemberId(memberId);
		notice.setSubject(subject);

		
		
		int result= nService.insertNotice(notice);
		
		if(result==1) {
			//여기엔 리스트 출력 하지만 지금은 안만들었으니 간단한 메세지
			response.sendRedirect("/notice/list.do");
			
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticeError.jsp");
			view.forward(request, response);
		}
	}

}
