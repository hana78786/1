package com.kh.student.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.student.model.vo.Student;
import com.kh.student.store.StudentStoreLogic;

public class StudentServicelmpl implements StudentService {
	//MVC패턴에서 Service의 역할은 무엇이었나요?
	//1. 연결 생성
	//2. 커밋 롤백
	
	
	@Override
	public int resgisterStudent(Student student) {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		int result = new StudentStoreLogic().insertStudent(session,student);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	@Override
	public Student printStudentByNo(int studentNo) {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		Student student = new StudentStoreLogic().selectStudentByNo(session,studentNo);
		return student;
	}



}
