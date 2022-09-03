package com.kh.lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.lecture.model.domain.Lecture;
import com.kh.lecture.model.service.LectureServiceImpl;

/**
 * Servlet implementation class LectureRegistController
 */
@WebServlet("/lecture/regist.do")
public class LectureRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LectureRegistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/lecture/registForm.jsp").forward(request, response);
		
		//forward빼먹어서 접속안됐음!! 빼먹지 말자!!!
		//views안에 넣어 접속이 안되는 주소는 getRequsetDispatcher로 접속하기!
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String lecturenName = request.getParameter("lectureName");
		String instructorName = request.getParameter("insturctorName");
		String lecturneIntroduce = request.getParameter("lectureIntroduce");
		Lecture lecture = new Lecture(lecturenName, instructorName, lecturneIntroduce);
		
		try {
		int result = new LectureServiceImpl().registLecture(lecture);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		if(result==1) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('강좌가 등록되었습니다')</script>");
		}
		}catch(Exception e){
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			request.setAttribute("msg", e.getMessage());
		}
		
	}

}
