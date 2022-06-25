package com.kh.student;

import java.beans.Statement;
import java.util.Scanner;

public class StudentInfor {
	private int kor;
	private int eng;
	private int math;
	private String name;
	Student[] student = new Student[3];

	public StudentInfor() {
//		for(int i=0; i<student.length;i++) {
//			student[i] = new Student(name, eng, kor, math);
//		}
	}

	public void printmenu() {
		System.out.println("====== 학생 정보 메뉴 ======");
		System.out.println("1. 학생 점수 입력");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

	public void StuInput() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < student.length; i++) {
			System.out.println("===== 학생정보 입력 =====");
			student[i] = new Student();
			System.out.print("학생 이름 : ");
			String name = scanner.next();
			System.out.print("국어 : ");
			int kor = scanner.nextInt();
			System.out.print("영어 : ");
			int eng = scanner.nextInt();
			System.out.print("수학 : ");
			int math = scanner.nextInt();
			student[i].setName(name);
			student[i].setEng(eng);
			student[i].setKor(kor);
			student[i].setMath(math);
		}

	}

	public void printInfo() {
		for (int i = 0; i < student.length; i++) {
			System.out.println("===학생 성적 출력 ===");
			System.out.println(student[i].getName() + "의 학생 성적");
			System.out.println("국어 : " + student[i].getKor());
			System.out.println("영어 : " + student[i].getEng());
			System.out.println("수학 : " + student[i].getMath());
			System.out.println("총점 : " + student[i].printTotal());
			System.out.println("평균 : " + student[i].printAvg());
		}
	}

}
