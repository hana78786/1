package com.kh.lecture.model.domain;

public class Lecture {
	private int lectureNo;
	private String lectureName;
	private String lectrueInstructor;
	private String lectureIntroduce;
	private String regDate;
	private String useYn;
	
	public Lecture() {
		
	}

	
	
	public Lecture(String lectureName, String lectrueInstructor, String lectureIntroduce) {
		super();
		this.lectureName = lectureName;
		this.lectrueInstructor = lectrueInstructor;
		this.lectureIntroduce = lectureIntroduce;
	}



	@Override
	public String toString() {
		return "Lecture [lectureNo=" + lectureNo + ", lectureName=" + lectureName + ", lectrueInstructor="
				+ lectrueInstructor + ", lectureIntroduce=" + lectureIntroduce + ", regDate=" + regDate + ", useYn="
				+ useYn + "]";
	}



	public int getLectureNo() {
		return lectureNo;
	}



	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}



	public String getLectureName() {
		return lectureName;
	}



	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}



	public String getLectrueInstructor() {
		return lectrueInstructor;
	}



	public void setLectrueInstructor(String lectrueInstructor) {
		this.lectrueInstructor = lectrueInstructor;
	}



	public String getlectureIntroduce() {
		return lectureIntroduce;
	}



	public void setlectureIntroduce(String lectureIntroduce) {
		this.lectureIntroduce = lectureIntroduce;
	}



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	public String getUseYn() {
		return useYn;
	}



	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	

}
