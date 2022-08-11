package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.service.NoticeService;

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
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Notice> nList = null;
		NoticeService nService = new NoticeService();
		int currentPage = 1;
		
		if(request.getParameter("currentPage")!=null) {
		 currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}
		
		
		PageData pd = null;
		pd = nService.noticeList(currentPage);
		//이제 페이지를 이동하고자 요청이 온 값을 다른 메소드로 보낸다
		nList=pd.getnList();
		String pageNavi = pd.getPagenavi();
		
		if (!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageNavi);
			


			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticeList.jsp");
			view.forward(request, response);

		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/notice/noticeError.jsp");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
