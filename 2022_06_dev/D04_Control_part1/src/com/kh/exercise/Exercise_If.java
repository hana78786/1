package com.kh.exercise;

import java.util.Scanner;

public class Exercise_If {
	public void exersize1() {
		// Ű����� ������ �Է¹ް� �Է¹��� ������ ����̰�
		// ¦���� �� "¦����"�� ����ϰ� ¦���� �ƴϸ� "Ȧ����"�� ����ϼ���
		// ��, ����� �ƴϸ� "����� �Է����ּ���"�� ����ϼ���.

		// �����ϳ� �Է����ּ��� : 4
		// ¦����.

		// �����ϳ� �Է����ּ��� : -2
		// ����� �Է����ּ���.
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int num = sc.nextInt();
//		if (num > 0) {
//			if (num % 2 == 0) {
//				System.out.println("¦���Դϴ�");
//			} else {
//				System.out.println("Ȧ���Դϴ�");
//			}
//		} else {
//			System.out.println("����� �Է��ϼ���");
//
//		}
		if (num > 0 && num % 2 == 0) {
			System.out.println("¦���Դϴ�");
		} else if (num < 0) {
			System.out.println("����� �Է����ּ���");
		} else if (num == 0) {
			System.out.println("0�Դϴ�.");
		} else if (num > 0 && num % 2 != 0) {
			System.out.println("Ȧ���Դϴ�");
		}
		sc.close();

	}

	public void exersize2() {
		/*
		 * �߰����, �⸻���, ��������, �⼮ȸ���� �Է��ϰ� Pass �Ǵ� Fail�� ����ϼ���. �򰡺����� �߰���� 20%, �⸻��� 30%,
		 * ���� 30%, �⼮ 100%�� �̷�����ְ� �� ��, �⼮ ������ �� ���� ȸ�� 20ȸ �߿��� �⼮�� ���� ���� ������ ��� 70�� �̻���
		 * ��� Pass(��, �⼮Ƚ�� ����), 70�� �̸��̰ų� ��ü ������ 30%�̻� �Ἦ �� Fail�� ����ϼ���.
		 * 
		 * �߰� ��� ����(20) : 70 �⸻ ��� ����(30) : 80 ���� ���� (30) : 77 �⼮ ���� (100) : 18
		 * 
		 * ���� : 78 Pass�Դϴ�!
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰� ��� ����(20) : ");
		int middle = sc.nextInt();
		System.out.print("�⸻ ��� ����(30) : ");
		int end = sc.nextInt();
		System.out.print("���� ����     (30) : ");
		int hw = sc.nextInt();
		System.out.print("�⼮ ����     (100) : ");
		int gw = sc.nextInt();

		double fin = middle * 0.2 + end * 0.3 + hw * 0.3 + gw;
		System.out.println("���� : " + fin);
		if (fin >= 70 && gw > 20 * 0.7) {
			System.out.println("pass �Դϴ�!");
		} else {
			if (gw <= 20 * 0.7 && fin < 70 ) {
				System.out.print("�⼮���� (" + gw + "ȸ �⼮)���� ���� ");
				System.out.print("���ÿ� 70���� ���� ���ؼ� (" + fin + "��) ");
			} else if (gw <= 20 * 0.7 ) {
				{
					System.out.print("�⼮���� (" + gw + "ȸ �⼮)���� ���� ");
				}
			} else {
				System.out.print("70���� ���� ���ؼ� (" + fin + "��) ");
			}
			System.out.println("Fail");
		}

	}
}
