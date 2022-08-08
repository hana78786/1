package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;

/**
 * Servlet implementation class loginServelet
 */
@WebServlet("/member/login.do")
public class loginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String memberId=request.getParameter("member-id");
	String memberPw=request.getParameter("member-pw");
	
	MemberService mService= new MemberService();
	int result= mService.loginCheck(memberId,memberPw);
	if(result==0) {
		
		response.sendRedirect("/member/Error.html");
		
		
		
	}else {
		HttpSession session = request.getSession();
		session.setAttribute("memberId",memberId);
		System.out.println("로그인성공");
		response.sendRedirect("/member/loginSuccess.html");
		
	}
	
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
