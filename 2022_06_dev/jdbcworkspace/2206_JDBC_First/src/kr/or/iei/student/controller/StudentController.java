package kr.or.iei.student.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import kr.or.iei.student.model.dao.StudentDAO;
import kr.or.iei.student.model.vo.Student;

public class StudentController {
	
	public int registerStudent(Student student) {
		
		StudentDAO sDao= new StudentDAO();
		int result = sDao.insertStudent(student); //studentDAO가 jdbc를 통해 db에 저장하도록 함
		//성공여부에 따라 숫자 리턴 성공1 실패0
		return result;
	}

	public ArrayList<Student> printAll() {
		StudentDAO sDao = new StudentDAO();
		ArrayList<Student> sList = sDao.AllStu();
		
		return sList;
		
		
	}

	public Student printOneById(String studentId) {
		StudentDAO sDao = new StudentDAO();
		Student student = sDao.selectOnebyid(studentId);
		return student;
	}

	public ArrayList<Student> printOnebyName(String studentName) {
		StudentDAO sDao = new StudentDAO();
		ArrayList<Student> sList = sDao.selectByName(studentName);
		
		return sList;
	}

	public int removeStudent(String studentId) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.removeStu(studentId);
		return result;
		
		
		
	}

	public int checkId(String studentId) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.checkId(studentId);
		
		return result;
	}

	public int modifyStudent(Student student) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.modifyStudent(student);
			
		return result;
	}

}
