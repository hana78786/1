package com.kh.lecture.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.lecture.common.SqlSessionTemplate;
import com.kh.lecture.model.domain.Lecture;
import com.kh.lecture.model.store.LecutreStoreLogic;

public class LectureServiceImpl implements LectureService {

	@Override
	public int registLecture(Lecture lecture) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new LecutreStoreLogic().insertLecture(session,lecture);
		if(result==1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public ArrayList<Lecture> allList() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Lecture>  Llist = new ArrayList<Lecture>();
		Llist = new LecutreStoreLogic().allList(session);
		
		return Llist;
	}

	@Override
	public Lecture lectureDetail(int lectureNo) {
		Lecture lecture = new Lecture();
		SqlSession session = SqlSessionTemplate.getSqlSession();
		lecture=new LecutreStoreLogic().lectureDetail(session, lectureNo);
		
		return lecture;
	}

	@Override
	public int deleteLecture(int lectureNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new LecutreStoreLogic().deleteLecture(session, lectureNo);
		if(result==1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int updateLecture(Lecture lecture) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new LecutreStoreLogic().updateLecture(session,lecture);
		if(result==1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	



}
