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
	// �޴�â �����
	public void printMenu() {
		System.out.println("====== �л� ���� ���α׷� ======");
		System.out.println("1. �л� ���� �Է�");
		System.out.println("2. �л� ���� ���");
		System.out.println("3. ���α׷� ����");
		System.out.print("���� ��ȣ �Է� : ");
	}

	// �Է¸޴� �����
	public void inputStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("====== �л� ���� �Է� â =====");
		Student[] student = new Student[3];
		for(int i=0; i<3 ; i ++) {
		student[i]= new Student();
		System.out.print("�л� �̸� : ");
		String name = scan.next();
		System.out.print("���� ���� : ");
		int kor = scan.nextInt();
		System.out.print("���� ���� : ");
		int eng = scan.nextInt();
		System.out.print("���� ���� : ");
		int math = scan.nextInt();
		System.out.println("====== �Է����� =====");
		student[i].setName(name);
		student[i].setEng(eng);
		student[i].setKor(kor);
		student[i].setMath(math);
		c++;
		}
		ct.setStudent(student);
	}
	// ��¸޴� �����
	public void printStudent() {
		System.out.println("====== �л� ���� ��� â =====");
		if(c==0) {System.out.println(">>>�Էµ� ������ �����ϴ�.<<<");
			
		}else {
		for(int i=0; i<3; i++) {
			Student std = ct.getStudent()[i]; 
			//Student[i] = Controller�� getStudent
			System.out.println((i+1)+"��° "+std.getName()+"�� �л� ����");
			System.out.println("���� ���� : "+std.getKor());
			System.out.println("���� ���� : "+std.getEng());
			System.out.println("���� ���� : "+std.getMath());
			System.out.println("�� �� : "+std.getTotal());
			System.out.println("��� ���� : "+std.getAvr());
			System.out.println("===== ���� â ���� =====");
		}
		
	}
	}

}
