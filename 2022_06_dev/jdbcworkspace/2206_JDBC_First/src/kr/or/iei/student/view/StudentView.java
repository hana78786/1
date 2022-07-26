package kr.or.iei.student.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.student.model.vo.Student;

public class StudentView {
	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== 학생 관리 프로그램 ===========");
		System.out.println("1. 학생정보 전체 조회");
		System.out.println("2. 학생 아이디로 조회");
		System.out.println("3. 학생 이름으로 조회");
		System.out.println("4. 학생 정보 등록");
		System.out.println("5. 학생 정보 번경");
		System.out.println("6. 학생 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("번호선택 : ");
		int input = sc.nextInt();
		return input;
	

	}
	public Student inputStudent() {
		Scanner sc = new Scanner(System.in);
		
		Student student = new Student();
		System.out.print("아이디 :");
		String studentId = sc.next();
		System.out.print("비밀번호 : ");
		String studentPwd = sc.next();
		System.out.print("이름 : ");
		String studentName = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		System.out.print("이메일 : ");
		String email= sc.next();
		System.out.print("전화번호 : ");
		String phone= sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address= sc.nextLine();
		System.out.print("취미 :");
		String hobby= sc.next();
		student.setStudentId(studentId);
		student.setAddress(address);
		student.setAge(age);
		student.setGender(gender);
		student.setHobby(hobby);
		student.setPhone(phone);
		student.setStudentPwd(studentPwd);
		student.setStudentName(studentName);
		student.setEmail(email);
		return student;
	}
	
	public void displaySuccess(String message) {
		message = message + "성공!";
		System.out.println(message);
	}
	
	public void displayfaild(String message) {
		message = message + "실패";
		System.out.println(message);
	}
	
	public void allstuview(ArrayList<Student> sList) {
		
		System.out.println("============전체 학생 정보 조회결과============");
		for(int i =0; i < sList.size(); i++) {
			Student sOne = sList.get(i);
			System.out.println("학생아이디 : "+sOne.getStudentId());
			System.out.println("비밀번호 : "+sOne.getStudentPwd());
			System.out.println("학생 이름 : "+sOne.getStudentName());
			System.out.println("학생 이메일 : "+sOne.getEmail());
			System.out.println("학생 전화번호 : "+sOne.getPhone());
			System.out.println("학생 나이 : "+sOne.getAge());
			System.out.println("학생 성별 : "+sOne.getGender());
			System.out.println("가입날짜 : "+sOne.getEnrollDAte());
			System.out.println("주소 : "+sOne.getAddress());
			System.out.println("취미 : "+sOne.getHobby());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
		}
	}
	public String inputStudentId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 아이디 입력 : ");
		String studentId = sc.next();
		return studentId;
	}
	public void showOne(Student student) {
		System.out.println("=============학생 정보 조회 결과 ===============");
		System.out.println("학생아이디 : "+student.getStudentId());
		System.out.println("비밀번호 : "+student.getStudentPwd());
		System.out.println("학생 이름 : "+student.getStudentName());
		System.out.println("학생 이메일 : "+student.getEmail());
		System.out.println("학생 전화번호 : "+student.getPhone());
		System.out.println("학생 나이 : "+student.getAge());
		System.out.println("학생 성별 : "+student.getGender());
		System.out.println("가입날짜 : "+student.getEnrollDAte());
		System.out.println("주소 : "+student.getAddress());
		System.out.println("취미 : "+student.getHobby());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
	}
	public String inputStudentName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 이름 입력 : ");
		return sc.next();
	}
	public Student modifyStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 수정할 정보를 입력하세요 =====");
		Student student = new Student();
		System.out.println("이름 : ");
		student.setStudentName(sc.next());
		System.out.println("비밀번호 :");
		student.setStudentPwd(sc.next());
		System.out.println("주소 : ");
		sc.nextLine();
		student.setAddress(sc.nextLine());
		System.out.println("취미 : ");
		student.setHobby(sc.next());
		return student;
	}

		
	
	
	
	}
	
