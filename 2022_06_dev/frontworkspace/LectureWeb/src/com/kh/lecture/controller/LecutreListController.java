package com.kh.lecture.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.lecture.model.domain.Lecture;
import com.kh.lecture.model.service.LectureServiceImpl;

/**
 * Servlet implementation class LecutreListController
 */
@WebServlet("/lecture/list.do")
public class LecutreListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<Lecture> Llist = new ArrayList<Lecture>(); 
			
			try {
			
				Llist = new LectureServiceImpl().allList();
				
				
				
			if(!Llist.isEmpty()) {
				
				//성공
				request.setAttribute("Llist", Llist);
				request.getRequestDispatcher("/WEB-INF/views/lecture/list.jsp").forward(request, response);
				//위아래 순서 틀리면 안나와 ㅠㅠ setAttribute먼저 requsetdispacher나중!
			}
			}catch(Exception e) {
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
	
			}
	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
