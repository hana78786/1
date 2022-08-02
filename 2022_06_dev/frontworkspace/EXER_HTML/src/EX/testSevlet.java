package EX;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testSevlet
 */
@WebServlet("/test/check.do")
public class testSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String name = request.getParameter("user-name");
	String animal = request.getParameter("animal");
	String color = request.getParameter("color");
	String[] foods = request.getParameterValues("foods");
	
	switch(color) {
	case "blue" : color="파란색"; break;
	case "green" : color="초록색"; break;
	case "yellow" : color="노란색"; break;
	case "red" : color="빨간색"; break;
	}
	switch(animal) {
	case "cat" : animal="고양이"; break;
	case "rabbit" : animal="토끼"; break;
	case "dog" : animal="강아지"; break;
	
	}
	for(int i =0; i<foods.length;i++) {
	switch(foods[i]) {
	case "jja" : foods[i]="짜장면"; break;
	case "cham" :foods[i] ="짬뽕"; break;
	case "man" : foods[i]="만두"; break;
	case "tang" : foods[i]="탕수육"; break;
	}
	}
	request.setAttribute("name", name);
	request.setAttribute("animal", animal);
	request.setAttribute("color", color);
	request.setAttribute("foods", foods);
	
	RequestDispatcher view = request.getRequestDispatcher("/taste/tasteResult.jsp");
	view.forward(request, response);
	
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
