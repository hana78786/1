package checkBox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkBoxServlet
 */
@WebServlet("/place/check.do")
public class checkBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
			
		String[] places= request.getParameterValues("place");
		request.setAttribute("places",places);
		RequestDispatcher view
		= request.getRequestDispatcher("/calculator/checkboxResult.jsp");
		view.forward(request, response);
		
//		for(String place : places) {
//			System.out.println(place + ",");
//		}
//		
//		PrintWriter out = response.getWriter();
//		out.println("<html><haed><title>관광지선택결과</title></head>");
//		out.println("<body><h2>관광지선택결과</h2>");
//		for(String place : places) {
//			out.println("선택한 장소는 "+place+"<br>");
//		}
//		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
