package com.kh.student;

import java.util.Scanner;

public class ManageStudent {
//	private int kor;
//	private int eng;
//	private int math;
//	private String name;
	Student[] student;
	public ManageStudent() {
	student = new Student[3];
	}

	public void showMenu() {
		System.out.println("===== 학생 성적관리 프로그램 =====");
		System.out.println("1. 학생 성적 입력");
		System.out.println("2. 학생 성적 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public void incertInfomation() {
		System.out.println("===== 학생 정보 입력 =====");
		Scanner scanner = new Scanner(System.in);
		System.out.print("학생 이름 입력 : ");
		String name = scanner.nextLine();
		System.out.print("국어 : ");
		int kor = scanner.nextInt();
		System.out.print("영어 : ");
		int eng = scanner.nextInt();
		System.out.print("수학 : ");
		int math = scanner.nextInt();
		student.setName(name);
		student.setEng(eng);
		student.setKor(kor);
		student.setMath(math);

	}

	public void printResult() {
		
		System.out.println(student.getName()+"의 성적");
		System.out.println("국어 점수 : " + student.getKor());
		System.out.println("영어 점수 : " + student.getEng());
		System.out.println("수학 점수 : " + student.getMath());
		System.out.println("총점 : " + student.printTotal());
		System.out.println("평균 : "+student.printAvg());
		

	}
}
