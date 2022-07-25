package view;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.Dao;
import Student.Student;

public class View {

	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 학생전체조회");
		System.out.println("2. 아이디조회");
		System.out.println("3. 이름조회");
		System.out.println("4. 정보등록");
		System.out.println("5. 정보변경");
		System.out.println("6. 정보삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public Student inputStudent() {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디");
		student.setStudent_id(sc.next());
		System.out.println("비밀번호");
		student.setStudent_pwd(sc.next());
		System.out.println("이름");
		student.setStudent_name(sc.next());
		System.out.println("나이");
		student.setAge(sc.nextInt());
		System.out.println("성별");
		student.setGender(sc.next().charAt(0));
		System.out.println("이메일");
		student.setEmail(sc.next());
		System.out.println("주소");
		sc.nextLine();
		student.setAddress(sc.nextLine());
		System.out.println("취미");
		student.setHobby(sc.next());
		System.out.println("전화");
		student.setPhone(sc.next());

		return student;
	}
	
	public void Success(String message) {
		System.out.println(message+"성공");
		
	}
	public void Faild(String message) {
		System.out.println(message+"실패");
		
	}

	public void printAllList(ArrayList<Student> sList) {
		
		for(int i =0; i<sList.size();i++) {
			Student sOne = sList.get(i);
			System.out.println(i+"번 학생정보");
			System.out.println("아이디 : "+sOne.getStudent_id());
			System.out.println("비밀번호 : "+sOne.getStudent_pwd());
			System.out.println("이름 : "+sOne.getStudent_name());
			System.out.println("나이 : "+sOne.getAge());
			System.out.println("주소 : "+sOne.getAddress());
			System.out.println("이메일 : "+sOne.getEmail());
			System.out.println("전화번호 : "+sOne.getPhone());
			System.out.println("취미 : "+sOne.getHobby());
			System.out.println("성별 : "+sOne.getGender());
			System.out.println("가입날짜 : "+sOne.getEnroll_date());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		}
		
		
		
	}

	public String insertId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 아이디 입력");
		String studentId = sc.next();
		
		
		return studentId;
	}
	
	
	public String insertname() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름 입력");
		String studentname = sc.next();
		
		
		return studentname;
	}
	

	public void serchStu(Student student) {
		System.out.println(" 학생정보");
		System.out.println("아이디 : "+student.getStudent_id());
		System.out.println("비밀번호 : "+student.getStudent_pwd());
		System.out.println("이름 : "+student.getStudent_name());
		System.out.println("나이 : "+student.getAge());
		System.out.println("주소 : "+student.getAddress());
		System.out.println("이메일 : "+student.getEmail());
		System.out.println("전화번호 : "+student.getPhone());
		System.out.println("취미 : "+student.getHobby());
		System.out.println("성별 : "+student.getGender());
		System.out.println("가입날짜 : "+student.getEnroll_date());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
	}
}
