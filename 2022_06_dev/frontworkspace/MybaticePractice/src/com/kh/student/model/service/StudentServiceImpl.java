package com.kh.student.model.service;



import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplat;
import com.kh.student.model.vo.Student;
import com.kh.student.sotre.StudentStoreLogic;

public class StudentServiceImpl implements StudentService{

	@Override
	public int resgisterStudent(Student student) {
		SqlSession session = SqlSessionTemplat.getSqlSession();
		int result = new StudentStoreLogic().insertStudent(session, student);
		if (result==1){
			session.commit();
		}else {
			session.rollback();
		}
		
		return result;
	}

	@Override
	public Student printStudentByNo(int studentNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
