package com.kh.student.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public interface StudentStore {
	public int insertStudent(SqlSession seesion, Student student);
	public Student selectStudentByNo(SqlSession session, int studentNo);

}
