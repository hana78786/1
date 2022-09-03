package com.kh.lecture.model.store;

import java.util.ArrayList;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;

import com.kh.lecture.model.domain.Lecture;

public interface LecutreStore {



	public int insertLecture(SqlSession session, Lecture lecture);
	
	public ArrayList<Lecture> allList(SqlSession session);

	public Lecture lectureDetail(SqlSession session, int lectureNo);
	
	public int deleteLecture(SqlSession session, int lectureNo);
	public int updateLecture(SqlSession session, Lecture lecture);
}
