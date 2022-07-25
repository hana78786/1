package com.kh.student.practice4;

import java.util.Scanner;


public class Consol {
	int c;
	String name;
	int kor;
	int eng;
	int math;
	Control cont = new Control();
	
	public Consol() {
		c = 0;
	}
	
	public void printMenu() {
		System.out.println("======학생정보메뉴=====");
		System.out.println("1. 정보입력");
		System.out.println("2. 정보출력");
		System.out.println("3. 종료");
		System.out.print("선택 : ");
	}

	public void inputStudent() {
		Scanner scan = new Scanner(System.in);
		Student student[] = new Student[3];
		for (int i = 0; i < 3; i++) {
			student[i] = new Student();
			System.out.println("======정보입력====");
			System.out.println("이름 : ");
			String name = scan.next();
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();
			System.out.println("====입력종료====");
			c++;
			student[i].setName(name);
			student[i].setEng(eng);
			student[i].setKor(kor);
			student[i].setMath(math);
		}
		cont.setStudent(student);
	}

	public void printStudent() {
		if (c == 0) {
			System.out.println("입력된 정보가 없습니다");
		} else {
			for(int i =0 ;i<3; i++ ) {
				Student std = cont.getStudent()[i];
			System.out.println("======정보출력====");
			System.out.println("이름 "+std.getName());
			System.out.println("국어 "+std.getKor());
			System.out.println("영어 "+std.getEng());
			System.out.println("수학 "+std.getMath());
			System.out.println("총점 "+std.getTotal());
			System.out.println("평균 "+std.getAvr());
			}
		}
	}
}
