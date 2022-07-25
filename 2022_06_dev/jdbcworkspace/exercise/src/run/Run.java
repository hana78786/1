package run;

import java.util.ArrayList;

import Controller.Controller;
import DAO.Dao;
import Student.Student;
import view.View;

public class Run {
	public static void main(String[] args) {
		int choice = 0;
		View view = new View();
		Student student = new Student();
		Controller cont = new Controller();
		Dao dao = new Dao();
		
		
		끝: while (true) {
			choice = view.menu();
			switch (choice) {	

			case 0:
				System.out.println("프로그램 종료");
				break 끝;
			case 1:
			ArrayList<Student>sList = cont.printAll();
			
			if(!sList.isEmpty()) {
				
				view.printAllList(sList);
				view.Success("조회");
			}else {
				view.Faild("조회");
			}
				
				break;
			case 2:
				String studentId = view.insertId();
				student = cont.serchId(studentId);
				view.serchStu(student);
				break;
			case 3:
				String studentname = view.insertname();
				student = cont.serchname(studentname);
				view.serchStu(student);
				
				break;
			case 4:
				student = view.inputStudent();
				int result = cont.registerStudent(student);
				if (result>0)
				{
					view.Success("입력");
					//성공
					
				}else {
					view.Faild("입력");
					//실패
				}
				
				break;
			case 5:
				//정보변경
				//아이디조회
				studentId = view.insertId();
				student = cont.updateId(studentId);
				//조회한 아이디값으로 다시 입력하게 하기
				
				
				
				
				break;
			case 6:
				//삭제
				//아이디조회
				studentId = view.insertId();
				student = cont.delId(studentId);
				view.Success("삭제");
				break;
			default:
				System.out.println("입력오류");
				break;

			}
		}
	}

}
