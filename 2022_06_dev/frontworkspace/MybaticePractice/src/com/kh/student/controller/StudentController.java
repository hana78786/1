package com.kh.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.student.model.service.StudentServiceImpl;
import com.kh.student.model.vo.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/member/register.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student= new Student();
		student.setStudentName("일용자");
		student.setStudentEmail("user@user.com");
		student.setStudentTel("000-000-0000");
		student.setStudentAddr("서울시 어쩌구");
		
		int result = new StudentServiceImpl().resgisterStudent(student);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.println("<script>alert('학생등록완료')</script>");
		}else {
			out.println("<script>alert('학생등록실패')</script>");
		}
		
		
		
	}

}
