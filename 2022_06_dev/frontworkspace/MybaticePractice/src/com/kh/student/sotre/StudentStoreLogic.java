package com.kh.student.sotre;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentStoreLogic implements StudentStore {

	@Override
	public int insertStudent(SqlSession session, Student student) {
		int result = session.insert("StudentMapper.insertStudent", student);
		// StudentMapper = mapper NameSpace를 인식한다. id(insertStudnet) 
		// serviceImple -> StoreLogic -> Mapper -> StoreLogic -> serviceImple -> Controller
		return result;
	}

	@Override
	public Student selectStudentByNo(SqlSession session, int studentNo) {
		Student student = session.selectOne("StudentMapper.selectOneStudent",studentNo);
		return null;
	}
	
	

}
