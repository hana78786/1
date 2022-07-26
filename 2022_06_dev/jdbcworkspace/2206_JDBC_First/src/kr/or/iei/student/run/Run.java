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

		끝: while (true) {
			int choice = view.mainMenu();
			switch (choice) {
			case 0:
				System.out.println("프로그램을 종료합니다");
				break 끝;
			case 1:
				sList = sCtrl.printAll();
				if (!sList.isEmpty()) {
					view.allstuview(sList);
				} else {
					view.displayfaild("불러오기");
				}

				break;
			case 2:
				String studentId = view.inputStudentId();
				student = sCtrl.printOneById(studentId);
				if (student.getStudentId() == null) {
					view.displayfaild("검색");
				} else {
					view.showOne(student);
				}
				break;

			case 3:
				String studentName = view.inputStudentName();
				sList = sCtrl.printOnebyName(studentName);
				if (sList.size() == 0) {
					view.displayfaild("검색");
				} else {
					view.allstuview(sList);
				}

				break;
			case 4:
				// 등록
				student = view.inputStudent();
				result = sCtrl.registerStudent(student);
				if (result > 0) {
					view.displaySuccess("저장");
				} else {
					view.displayfaild("저장");
				}
				break;
			case 5:
				//회원아이존재확인
				//있으면 수정
				//없으면 조회실패 메세지	
				studentId = view.inputStudentId();
				result = sCtrl.checkId(studentId);
				if (result == 0) {
					view.displayfaild("검색");
				} else {
					view.displaySuccess("검색");
					student = view.modifyStudent();
					student.setStudentId(studentId);
					result = sCtrl.modifyStudent(student);
					if(result>0) {
						view.displaySuccess("수정");
					}else {
						view.displayfaild("수정");
					}
					
				}
				
				
				
				break;
			case 6:
				studentId = view.inputStudentId();
				result = sCtrl.removeStudent(studentId);
				if (result > 0) {
					view.displaySuccess("삭제");
				} else {
					view.displayfaild("삭제");
				}
				break;
			default:
				System.out.println("잘못입력하셨습니다");
				break;
			}
		}
	}
}
