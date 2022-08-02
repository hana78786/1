package exam;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("user-name");
		String color = request.getParameter("color");
		String animal= request.getParameter("animal");
		String[] foods = request.getParameterValues("foods");
		
		System.out.println("이름 "+name);
		System.out.println("좋아하는 색 "+color);
		System.out.println("좋아하는 동물 "+animal);
		System.out.println("좋아하는 음식은");
		for(String food : foods) {
		System.out.print(food+" ");}
		
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
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>내 취향</title></head>");
		out.println("<body><h1> 개인취향테스트 결과 화면 </h1>");
		out.println(name+"님의 개인 취향은<br>");
		out.println(color+"색을 좋아하고 <br>");
		out.println(animal+"를 좋아합니다<br>");
		out.println("좋아하는 음식은");
		for(int i =0 ; i<foods.length;i++) {
		out.print(foods[i]);
		if (i != foods.length-1) {
			out.print(", ");
		}
			
		}
		out.println(" 입니다");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
