package com.kh.program;

import java.util.Scanner;

public class ScorProgram {
	static int kor = 0;
	static int eng = 0;
	static int math = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		����: while (true) {
			printMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				incertScore();
				break;
			case 2:
				printScore();
				break;
			case 3:
				System.out.println("�����մϴ�.");
				sc.close();
				break ����;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				break;

			}
		}

	}

	static void printMainMenu() {
		System.out.println("===== ���� �޴� =====");
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ����");
		System.out.println("���� : ");
	
	}
	static void incertScore() {
		Scanner sc= new Scanner(System.in);
		System.out.println("===== ���� �Է� =====");
		System.out.println("����� : ");
		kor = sc.nextInt();
		System.out.println("����� : ");
		eng = sc.nextInt();
		System.out.println("���м��� : ");
		math = sc.nextInt();
		
	}
	static void printScore() {
		System.out.println("==== ���� ��� =====");
		System.out.println("����� : " + kor);
		System.out.println("����� : " + eng);
		System.out.println("���м��� : " + math);
		int total = kor + eng + math;
		double avg = total / 3;
		System.out.println("���� :" + total);
		System.out.println("��� : " + avg);
	}
}
