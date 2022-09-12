package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
@WebServlet("/ten") //여기의 입력된 주소는 내가 이 서블릿을 접속하고자 하는 경로로 정해준다.
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request  서버가 요청하는것을 받는 객체
		// response 클라이언트에게 응답하는 객체
		response.setContentType("text/html; charset=UTF-8"); //클라이언트(웹브라우저)가 응답을 받았을때 서버가 응답보낸 객체의 타입이 무엇인지 파악할수있게 알려주는 코드
		//text로 보낼것이다 이 text는 html이다 응답은 utf-8로 보낼것이다.
		PrintWriter out = response.getWriter();//보낼 통로 객체 생성 여기서는 텍스트를 입력할수있는 getWriter라는 통로를 만들어 사용, 그걸  out으로 정의
		out.print("<h1>1~10</h1>");
		for(int i=1; i<11;i++) {//for문을 이용해 10개의 out객체 생성
			out.print(i+"<br>");
		}
		out.close();//사용후 닫음
	}
}
