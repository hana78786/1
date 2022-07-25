package com.kh.student.practice2;

import java.util.Scanner;

public class Consol {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	Cotroller ct;
	private int c;
	
	public Consol() {
	ct = new Cotroller();
	c=0;
		
	}
	// 메뉴창 만들기
	public void printMenu() {
		System.out.println("====== 학생 정보 프로그램 ======");
		System.out.println("1. 학생 정보 입력");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택 번호 입력 : ");
	}

	// 입력메뉴 만들기
	public void inputStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("====== 학생 정보 입력 창 =====");
		Student[] student = new Student[3];
		for(int i=0; i<3 ; i ++) {
		student[i]= new Student();
		System.out.print("학생 이름 : ");
		String name = scan.next();
		System.out.print("국어 점수 : ");
		int kor = scan.nextInt();
		System.out.print("영어 점수 : ");
		int eng = scan.nextInt();
		System.out.print("수학 점수 : ");
		int math = scan.nextInt();
		System.out.println("====== 입력종료 =====");
		student[i].setName(name);
		student[i].setEng(eng);
		student[i].setKor(kor);
		student[i].setMath(math);
		c++;
		}
		ct.setStudent(student);
	}
	// 출력메뉴 만들기
	public void printStudent() {
		System.out.println("====== 학생 정보 출력 창 =====");
		if(c==0) {System.out.println(">>>입력된 정보가 없습니다.<<<");
			
		}else {
		for(int i=0; i<3; i++) {
			Student std = ct.getStudent()[i]; 
			//Student[i] = Controller의 getStudent
			System.out.println((i+1)+"번째 "+std.getName()+"의 학생 정보");
			System.out.println("국어 성적 : "+std.getKor());
			System.out.println("영어 성적 : "+std.getEng());
			System.out.println("수학 성적 : "+std.getMath());
			System.out.println("총 점 : "+std.getTotal());
			System.out.println("평균 성적 : "+std.getAvr());
			System.out.println("===== 정보 창 종료 =====");
		}
		
	}
	}

}
