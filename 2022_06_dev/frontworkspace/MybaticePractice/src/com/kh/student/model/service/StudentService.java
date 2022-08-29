package com.kh.student.model.service;

import com.kh.student.model.vo.Student;

public interface StudentService {
	
	public int resgisterStudent(Student student);
	public Student printStudentByNo(int studentNo);

}
