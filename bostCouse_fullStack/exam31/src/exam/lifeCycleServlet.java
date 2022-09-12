package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lifeCycleServlet
 */
@WebServlet("/lifeCycleServlet")
public class lifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public lifeCycleServlet() {
		System.out.println("LifeCycleServlet 생성");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init호출 (수정)");
	}

	public void destroy() {
		System.out.println("destory호출");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/exam31/lifeCycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("service호출");
//	}

	
	
}
