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
		System.out.println("======�л������޴�=====");
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ����");
		System.out.print("���� : ");
	}

	public void inputStudent() {
		Scanner scan = new Scanner(System.in);
		Student student[] = new Student[3];
		for (int i = 0; i < 3; i++) {
			student[i] = new Student();
			System.out.println("======�����Է�====");
			System.out.println("�̸� : ");
			String name = scan.next();
			System.out.print("���� : ");
			int kor = scan.nextInt();
			System.out.print("���� : ");
			int eng = scan.nextInt();
			System.out.print("���� : ");
			int math = scan.nextInt();
			System.out.println("====�Է�����====");
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
			System.out.println("�Էµ� ������ �����ϴ�");
		} else {
			for(int i =0 ;i<3; i++ ) {
				Student std = cont.getStudent()[i];
			System.out.println("======�������====");
			System.out.println("�̸� "+std.getName());
			System.out.println("���� "+std.getKor());
			System.out.println("���� "+std.getEng());
			System.out.println("���� "+std.getMath());
			System.out.println("���� "+std.getTotal());
			System.out.println("��� "+std.getAvr());
			}
		}
	}
}
