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
		System.out.println("====== �л� ���� �޴� ======");
		System.out.println("1. �л� ���� �Է�");
		System.out.println("2. �л� ���� ���");
		System.out.println("3. ���α׷� ����");
		System.out.print("�޴� ���� : ");
	}

	public void StuInput() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < student.length; i++) {
			System.out.println("===== �л����� �Է� =====");
			student[i] = new Student();
			System.out.print("�л� �̸� : ");
			String name = scanner.next();
			System.out.print("���� : ");
			int kor = scanner.nextInt();
			System.out.print("���� : ");
			int eng = scanner.nextInt();
			System.out.print("���� : ");
			int math = scanner.nextInt();
			student[i].setName(name);
			student[i].setEng(eng);
			student[i].setKor(kor);
			student[i].setMath(math);
		}

	}

	public void printInfo() {
		for (int i = 0; i < student.length; i++) {
			System.out.println("===�л� ���� ��� ===");
			System.out.println(student[i].getName() + "�� �л� ����");
			System.out.println("���� : " + student[i].getKor());
			System.out.println("���� : " + student[i].getEng());
			System.out.println("���� : " + student[i].getMath());
			System.out.println("���� : " + student[i].printTotal());
			System.out.println("��� : " + student[i].printAvg());
		}
	}

}
