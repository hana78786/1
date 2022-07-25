package com.kh.student.practice;

import java.util.Scanner;

public class StudentConsol {
	StudentController sController; 
	int c=0;
	public StudentConsol() {
		sController= new StudentController();
	}

	// 메뉴만들기
	public void printmenu() {
		System.out.println("==== 학생관리 프로그램 =====");
		System.out.println("1. 학생 정보 입력");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("입력 : ");
	}

	// 입력창 만들기
	public void inputImpo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== 정보 입력창 =====");
		Student[] students = new Student[3];
		for (int i = 0; i < 3; i++) {
			students[i]= new Student();
			System.out.print("학생 이름 :");
			String name = scanner.next();
			System.out.print("국어 점수 :");
			int kor = scanner.nextInt();
			System.out.print("영어 점수 :");
			int eng = scanner.nextInt();
			System.out.print("수학 점수 :");
			int math = scanner.nextInt();
			System.out.println("====== 입력종료 ======");
			students[i].setName(name);
			students[i].setKor(kor);
			students[i].setEng(eng);
			students[i].setMath(math);
			c++;
		}
		sController.setStudent(students); // 최종저장
	}

	// 출력창 만들기
	public void printImpo() {
		System.out.println("==== 학생 정보 출력 =====");
		if(c==0) {System.out.println("입력된 학생정보가 없습니다.");}
		else {
		for (int i = 0; i < 3; i++) {
			Student std = sController.getStudents()[i];
			System.out.println((i+1)+"번째 "+std.getName() + "의 학생 정보");
			System.out.println("국어 점수 : " + std.getKor());
			System.out.println("영어 점수 : " + std.getEng());
			System.out.println("수학 점수 : " + std.getMath());
			System.out.println("총 합 : " + std.printTotal());
			System.out.println("평균 점수 : " + std.printAvr());
		}
		System.out.println("==== 정보창 종료 ====");
	}}
}
