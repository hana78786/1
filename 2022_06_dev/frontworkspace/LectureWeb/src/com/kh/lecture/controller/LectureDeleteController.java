package com.kh.lecture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.lecture.model.service.LectureServiceImpl;

/**
 * Servlet implementation class LectureDeleteController
 */
@WebServlet("/lecture/delete.do")
public class LectureDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int lectureNo = Integer.parseInt(request.getParameter("lectureNo"));
	try {
	int result = new LectureServiceImpl().deleteLecture(lectureNo);
	
	if(result==1) {
		request.getRequestDispatcher("/lecture/list.do").forward(request, response);
	}
	
	}catch(Exception e) {
		
		request.setAttribute("msg",e.getMessage() );
		request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);

		
	}
	
	
	}

	
}
