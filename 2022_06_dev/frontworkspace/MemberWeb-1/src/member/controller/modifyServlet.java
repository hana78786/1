package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.MemberService;

/**
 * Servlet implementation class modifyServlet
 */
@WebServlet("/member/modify.do")
public class modifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String email = request.getParameter("member-email");
		String memberAddress = request.getParameter("member-address");
		char gender = request.getParameter("gender").charAt(0);
		String memberHobby= request.getParameter("member-hobby");
		String phone = request.getParameter("member-phone");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setEmail(email);
		member.setMemberAddress(memberAddress);
		member.setGender(gender);
		member.setMemberHobby(memberHobby);
		member.setPhone(phone);
		
		MemberService mService = new MemberService();
		int result = mService.modifyMember(member);
		if(result==1) {
			response.sendRedirect("/index.jsp");
		}else {
			//에러메세지
			response.sendRedirect("/member/Error.html");
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
