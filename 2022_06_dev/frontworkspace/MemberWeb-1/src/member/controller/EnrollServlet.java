package member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.MemberService;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/member/enroll.do")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberName=request.getParameter("member-name");
		String memberId=request.getParameter("member-id");
		String memberPw=request.getParameter("member-pw");
		String memberAddress=request.getParameter("member-address");
		char gender=request.getParameter("gender").charAt(0);
		int memberAge=Integer.parseInt(request.getParameter("member-age"));
		String memberHobby=request.getParameter("member-hobby");
		String phone=request.getParameter("member-phone");
		String email=request.getParameter("member-email");
		
		Member member = new Member();
		member.setEmail(email);
		member.setGender(gender);
		member.setMemberAddress(memberAddress);
		member.setMemberHobby(memberHobby);
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		member.setMemberPw(memberPw);
		member.setPhone(phone);
		member.setMemberAge(memberAge);
		
		MemberService mService = new MemberService();
		
		int result = mService.insertMember(member);
		
		if(result==1) {
			response.sendRedirect("/index.jsp");
			
		}else {
			response.sendRedirect("/member/error.html");
			
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
