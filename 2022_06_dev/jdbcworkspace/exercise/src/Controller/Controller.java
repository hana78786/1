package Controller;

import java.util.ArrayList;

import DAO.Dao;
import Student.Student;

public class Controller {
	
	public int registerStudent(Student student) {
		Dao dao = new Dao();
		int result = dao.insertStudent(student);
		
		return result;
		
	}

	public ArrayList<Student> printAll(){
		
		Dao dao = new Dao();
		ArrayList<Student> sList = dao.AllStudent();
		
		return sList;
		
	}

	public Student serchId(String studentId) {
		Dao dao = new Dao();
		Student student = dao.serchId(studentId);
		

		return student;
	}

	public Student serchname(String studentname) {
		Dao dao = new Dao();
		Student student = dao.serchname(studentname);
		

		return student;
	}

	public Student updateId(String studentId) {
		Dao dao = new Dao();
		Student student = dao.updateId(studentId);
		

		return student;
	}

	public Student delId(String studentId) {
		Dao dao = new Dao();
		Student student = dao.deleteId(studentId);
		

		return student;
	}
}
