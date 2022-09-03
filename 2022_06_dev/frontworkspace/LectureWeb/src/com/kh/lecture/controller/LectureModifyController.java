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
 * Servlet implementation class LectureModifyController
 */
@WebServlet("/lecture/modify.do" )
public class LectureModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int lectureNo = Integer.parseInt(request.getParameter("lectureNo"));
		Lecture lecture = new Lecture();
		lecture = new LectureServiceImpl().lectureDetail(lectureNo);

		try {
			request.setAttribute("lecture", lecture);
			request.getRequestDispatcher("/WEB-INF/views/lecture/modify.jsp").forward(request, response);
		} catch (Exception e) {

			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int lectureNo =Integer.parseInt(request.getParameter("lectureNo"));
		String lectureName = request.getParameter("lectureName");
		String lectrueInstructor = request.getParameter("lectrueInstructor");
		String lectureIntroduce = request.getParameter("lectureIntroduce");
		String useYn = request.getParameter("YN");
		Lecture lecture = new Lecture();
		lecture.setLectureNo(lectureNo);
		lecture.setLectureName(lectureName);
		lecture.setLectrueInstructor(lectrueInstructor);
		lecture.setlectureIntroduce(lectureIntroduce);
		lecture.setUseYn(useYn);
	
		int result = new LectureServiceImpl().updateLecture(lecture);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		try {
			if(result==1) {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('수정완료');location.href='/lecture/detail.do?lectureNo="+lectureNo+"';</script>");
				
				out.flush();
				out.close();
				
			
			//request.getRequestDispatcher("/lecture/list.do").forward(request, response);
			
			}
			} catch (Exception e) {

			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);

		}
		
	
		
		
		
	}

}
