package com.kh.student.model.service;

import com.kh.student.model.vo.Student;

public interface StudentService {
//공동작업을 할때 인터페이스를 이용해서 메소드명을 통일시켜주는 역할을 함
	//1. 인터페이서
	//2. 추상메소드
	//3. 오버라이딩
	public int resgisterStudent(Student student);
	public Student printStudentByNo(int studentNo);
}
