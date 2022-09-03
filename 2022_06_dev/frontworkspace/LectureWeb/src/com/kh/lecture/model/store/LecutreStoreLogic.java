package com.kh.lecture.model.store;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;

import com.kh.lecture.model.domain.Lecture;

public class LecutreStoreLogic implements LecutreStore {

	@Override
	public int insertLecture(SqlSession session, Lecture lecture) {
		int result = session.insert("LectureMapper.insertLecture",lecture);
		return result;
	}

	@Override
	public ArrayList<Lecture> allList(SqlSession session) {
		List<Lecture> Llist = session.selectList("LectureMapper.selectList");
		
		return (ArrayList<Lecture>)Llist;
	}

	@Override
	public Lecture lectureDetail(SqlSession session, int lectureNo) {
		Lecture lecture = new Lecture();
		lecture = session.selectOne("LectureMapper.selectOne", lectureNo);
		
		return lecture;
	}

	@Override
	public int deleteLecture(SqlSession session, int lectureNo) {
		int result = session.delete("LectureMapper.deleteId", lectureNo);
		return result;
	}
	
	@Override
	public int updateLecture(SqlSession session, Lecture lecture) {
		int result = session.update("LectureMapper.updateId", lecture);
		return result;
	}

	

	



}
