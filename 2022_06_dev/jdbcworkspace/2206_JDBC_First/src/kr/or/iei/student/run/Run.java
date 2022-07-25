package kr.or.iei.student.run;

import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.iei.student.controller.StudentController;
import kr.or.iei.student.model.dao.StudentDAO;
import kr.or.iei.student.model.vo.Student;
import kr.or.iei.student.view.StudentView;

public class Run {
	public static void main(String[] args) {
		StudentView view = new StudentView();
		Student student = null;
		StudentController sCtrl = new StudentController(); 
		StudentDAO sDAO = new StudentDAO(); 
		int result = 0;
		ArrayList<Student> sList = null;
		
		끝 : while (true) {
			int choice = view.mainMenu();
			switch (choice) {
			case 0:
				System.out.println("프로그램을 종료합니다");
				break 끝;
			case 1:
				sList = sCtrl.printAll();
				if(!sList.isEmpty()) {
					view.allstuview(sList);
				}
				else {
					view.displayfaild("불러오기");
				}
				
				
				break;
			case 2:
				String studentId = view.inputStudentId();
				student = sCtrl.printOneById(studentId);
				view.showOne(student);
				break;
			case 3:
				break;
			case 4:
				//등록
				student = view.inputStudent();
				result = sCtrl.registerStudent(student);
				if(result>0) {
					view.displaySuccess("저장");
				}else {
					view.displayfaild("저장");
				}
				break;
			case 5:
				break;
			case 6:
				break;
				default : System.out.println("잘못입력하셨습니다");break;
			}
		}
	}
}
