package com.kh.exscanner;

import java.util.Scanner;

public class TestScanner3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ���");
		String name = sc.next();
		System.out.println("�¾ ���� �Է����ּ���");
		int birth = sc.nextInt();
		System.out.println("Ű�� �Է����ּ���");
		double tall = sc.nextDouble();
		System.out.println("������ �Է����ּ��� ��/�� ");
		char gen = sc.next().charAt(0);
		System.out.println("�ּҸ� �Է����ּ��� (00�� 00��)");
		sc.nextLine(); //���͸� ���鰪���� �Է¹ޱ⶧���� ���͸� �Է¹޾��� �ڵ带 �־�� �Ѵ�
		String Adre = sc.next();

		System.out.println("�̸��� " + name + "�Դϴ�.");
		System.out.println(birth + "�� �¾���ϴ�.");
		System.out.println("Ű�� " + tall + "�Դϴ�");
		System.out.println("������ " + gen + " �Դϴ�");
		System.out.println("�ּҴ�" + Adre + "�Դϴ�");


	}
}
