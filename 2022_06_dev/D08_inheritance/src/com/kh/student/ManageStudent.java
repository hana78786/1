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
		student.setName(name);
		student.setEng(eng);
		student.setKor(kor);
		student.setMath(math);

	}

	public void printResult() {
		
		System.out.println(student.getName()+"�� ����");
		System.out.println("���� ���� : " + student.getKor());
		System.out.println("���� ���� : " + student.getEng());
		System.out.println("���� ���� : " + student.getMath());
		System.out.println("���� : " + student.printTotal());
		System.out.println("��� : "+student.printAvg());
		

	}
}
