package com.kh.student.practice2;

public class Cotroller {
	private Student[] student;
	
	public Student[] getStudent() {
		return student;
	}
	public void setStudent(Student[] student) {
		this.student = student;
	}
	public Cotroller() {
		student = new Student[3];
		
	}

}
