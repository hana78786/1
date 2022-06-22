package com.kh.student;

import java.util.Scanner;

public class ManageStudent {
	private int kor;
	private int eng;
	private int math;
	private String name;
	Student[] student;
	public int i;
	public int c;
	public ManageStudent() {
	student = new Student[3];
	student[0] =new Student(name,eng,kor,math);
	student[1] =new Student(name,eng,kor,math);
	student[2] =new Student(name,eng,kor,math);
	c=0;
	
	}

	public void showMenu() {
		System.out.println("===== �л� �������� ���α׷� =====");
		System.out.println("1. �л� ���� �Է�");
		System.out.println("2. �л� ���� ���");
		System.out.println("3. ���α׷� ����");
		System.out.print("���� : ");
	}

	public void incertInfomation() {
		System.out.println("===== �л� ���� �Է� =====");
		Scanner scanner = new Scanner(System.in);
		System.out.print("�л� �̸� �Է� : ");
		String name = scanner.nextLine();
		System.out.print("���� : ");
		int kor = scanner.nextInt();
		System.out.print("���� : ");
		int eng = scanner.nextInt();
		System.out.print("���� : ");
		int math = scanner.nextInt();
		student[c].setName(name);
		student[c].setEng(eng);
		student[c].setKor(kor);
		student[c].setMath(math);
		c++;
		if(c>=3) {
			c=c%3;
		}
	}

	public void printResult() {
		for(i=0;i<3;i++) {
		System.out.println(student[i].getName()+"�� ����");
		System.out.println("���� ���� : " + student[i].getKor());
		System.out.println("���� ���� : " + student[i].getEng());
		System.out.println("���� ���� : " + student[i].getMath());
		System.out.println("���� : " + student[i].printTotal());
		System.out.println("��� : "+student[i].printAvg());
		}

	}
}
