package com.kh.student.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentStoreLogic {

	public int insertStudent(SqlSession session, Student student) {
		int result = session.insert("StudentMapper.insertStudent",student);
		return result;
	}

	public Student selectStudentByNo(SqlSession session, int studentNo) {
		Student student= session.selectOne("StudentMapper.selectOneStudent",studentNo);
		return student;
	}
	
	

}
