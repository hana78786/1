package com.kh.student.model.vo;

import java.sql.Date;

public class Student {

	private String studentName;
	private String studentTel;
	private String studentEmail;
	private String studentAddr;
	private Date regDate;
	
	public Student() {
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentTel=" + studentTel + ", studentEmail=" + studentEmail
				+ ", studentAddr=" + studentAddr + ", regDate=" + regDate + "]";
	}




	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentAddr() {
		return studentAddr;
	}
	public void setStudentAddr(String studentAddr) {
		this.studentAddr = studentAddr;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
