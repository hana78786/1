package test.Member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Member.Member;

/**
 * Servlet implementation class El_CheckServlet
 */
@WebServlet("/el/check.do")
public class El_CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public El_CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member("user02", "pass02","이용자");
		ArrayList<Member>mList = new ArrayList<Member>();
		mList.add(new Member("user03","pass03","삼용자"));
		mList.add(new Member("user04","pass04","사용자"));
		mList.add(new Member("user05","pass05","오용자"));
		
		request.setAttribute("Member", member);
		request.setAttribute("mList", mList);
		RequestDispatcher view = request.getRequestDispatcher("/EL/jsp_ElTest1.jsp");
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
