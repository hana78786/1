package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class examServlet
 */
@WebServlet("/exam/test.do")
public class examServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public examServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name = request.getParameter("user-name");
		String color = request.getParameter("color");
		String animal= request.getParameter("animal");
		String[] foods = request.getParameterValues("foods");
		
		switch(color) {
		case "blue" : color="파랑"; break;
		case "yellow" : color="노랑";break;
		case "red" : color="빨강";break;
		case "green" : color="초록";break;
		default : color="선택안함";break;
		}
		
		switch(animal) {
		case "cat" : animal ="고양이"; break;
		case "dog" : animal ="강아지"; break;
		case "rabbit" : animal ="토끼"; break;
		}
		
		for(int i =0; i<foods.length;i++) {
			switch(foods[i]) {
				case "jjajjang" : foods[i]="짜장면"; break;
				case "champong" : foods[i]="짬뽕"; break;
				case "tangsuyuk" : foods[i]="탕수육" ;break;
				case "yangjangpi" : foods[i]="양장피" ;break;
				case "palboche" : foods[i]="팔보채"; break;
				
			}
			
		}
		
		request.setAttribute("name", name);
		request.setAttribute("color", color);
		request.setAttribute("animal", animal);
		request.setAttribute("foods", foods);
		
		RequestDispatcher view =
				request.getRequestDispatcher("/calculator/exam.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
