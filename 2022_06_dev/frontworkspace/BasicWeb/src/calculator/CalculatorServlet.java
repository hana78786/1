package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/cal/result.do")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CalculatorServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstNum = request.getParameter("first-num");
		String secondNum = request.getParameter("second-num");
		String operator = request.getParameter("operator");

		int num1 = Integer.parseInt(firstNum);
		int num2 = Integer.parseInt(secondNum);
		char op = operator.charAt(0);
		int result = 0;

		switch (op) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		case '*':
			result = num1 * num2;
			break;

		}
		
		request.setAttribute("first", num1);
		request.setAttribute("second", num2);
		request.setAttribute("operator",op);
		request.setAttribute("result", result);
		
		RequestDispatcher view
		= request.getRequestDispatcher("/calculator/calResult.jsp");
		view.forward(request, response);
		
//		System.out.println(result);
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=utf-8");
//		
//		PrintWriter out = response.getWriter();
//		out.println("<html><title>결과보기</title>");
//		out.println("<body><h1>계산결과는 다음과 같습니다</h1>");
//		out.println(num1+" "+op+" "+num2+" "+"= "+result);
//		out.println("<body></html>");
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
