package com.kh.student.practice;

import java.util.Scanner;

public class StudentConsol {
	StudentController sController; 
	int c=0;
	public StudentConsol() {
		sController= new StudentController();
	}

	// �޴������
	public void printmenu() {
		System.out.println("==== �л����� ���α׷� =====");
		System.out.println("1. �л� ���� �Է�");
		System.out.println("2. �л� ���� ���");
		System.out.println("3. ���α׷� ����");
		System.out.print("�Է� : ");
	}

	// �Է�â �����
	public void inputImpo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== ���� �Է�â =====");
		Student[] students = new Student[3];
		for (int i = 0; i < 3; i++) {
			students[i]= new Student();
			System.out.print("�л� �̸� :");
			String name = scanner.next();
			System.out.print("���� ���� :");
			int kor = scanner.nextInt();
			System.out.print("���� ���� :");
			int eng = scanner.nextInt();
			System.out.print("���� ���� :");
			int math = scanner.nextInt();
			System.out.println("====== �Է����� ======");
			students[i].setName(name);
			students[i].setKor(kor);
			students[i].setEng(eng);
			students[i].setMath(math);
			c++;
		}
		sController.setStudent(students); // ��������
	}

	// ���â �����
	public void printImpo() {
		System.out.println("==== �л� ���� ��� =====");
		if(c==0) {System.out.println("�Էµ� �л������� �����ϴ�.");}
		else {
		for (int i = 0; i < 3; i++) {
			Student std = sController.getStudents()[i];
			System.out.println((i+1)+"��° "+std.getName() + "�� �л� ����");
			System.out.println("���� ���� : " + std.getKor());
			System.out.println("���� ���� : " + std.getEng());
			System.out.println("���� ���� : " + std.getMath());
			System.out.println("�� �� : " + std.printTotal());
			System.out.println("��� ���� : " + std.printAvr());
		}
		System.out.println("==== ����â ���� ====");
	}}
}
