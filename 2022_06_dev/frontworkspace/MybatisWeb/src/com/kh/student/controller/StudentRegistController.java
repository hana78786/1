package com.kh.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.student.model.service.StudentServicelmpl;
import com.kh.student.model.vo.Student;

/**
 * Servlet implementation class StudentRegistController
 */
@WebServlet("/student/regist.do")
public class StudentRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setStudentName("일용자");
		student.setStudentTel("01000000000");
		student.setStudentEmail("user01@user.kr");
		student.setStudentAddr("서울시 중구");
		int result= new StudentServicelmpl().resgisterStudent(student);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.println("<script>alert('학생등록완료')</script>");
		}else {
			out.println("<script>alert('학생등록실패')</script>");
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
