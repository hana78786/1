package com.kh.score;

import java.util.Scanner;

public class ScoreFunction {
	private int kor;
	private int eng;
	private int math;
	public void printMainMenu() {
		System.out.println("===== ���θ޴� =====");
		System.out.println("1. ���� �Է�");
		System.out.println("2. ���� ���");
		System.out.println("3. ����");
		System.out.print("���� : ");

	}

	public void insertScore() {
		System.out.println("������ �Է��ϼ���");
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� : ");
		kor = scanner.nextInt();
		System.out.print("���� : ");
		eng = scanner.nextInt();
		System.out.print("���� : ");
		math = scanner.nextInt();

	}

	public void printScore() {
		double total = kor + eng + math;
		double avg = total / 3;
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("���� : " + math);
		System.out.println("���� : " + total);
		System.out.println("��� : "+ avg);

	}
}
