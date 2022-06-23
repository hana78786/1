package com.kh.student.practice;

public class StudentController {
	private Student[] students;
	
	public StudentController() {
		students = new Student[3]; 
	}
	public void setStudent(Student [] students) {
		this.students = students;
	}
	public Student[] getStudents() {
		return students;
	}



}


