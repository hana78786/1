package com.kh.lecture.model.service;

import java.util.ArrayList;

import com.kh.lecture.model.domain.Lecture;

public interface LectureService {
	
	public int registLecture(Lecture lecture);
	
	public ArrayList<Lecture> allList();
	
	public Lecture lectureDetail(int lectureNo);
	public int deleteLecture(int lectureNo);
	public int updateLecture(Lecture lecture);

}
