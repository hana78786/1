package com.kh.control;

import java.util.Scanner;

public class Exercise_Switch {
	public void exercise1() {
		// 1 ~ 3 ������ ������ �Է¹޾�
		// 1�� ��� ������ �Դϴ�.
		// 2�� ��� �Ķ����Դϴ�.
		// 3�� ��� �ʷϻ��Դϴ�.
		// �׿��� ������ �Է��� ��� �߸��Է��ϼ̽��ϴٸ� ����ϼ���.
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~3���̿� ���ڸ� �Է����ּ��� : ");
		int menu = scanner.nextInt();
		switch (menu) {
		case 1:
			System.out.println("�������Դϴ�");
			break;
		case 2:
			System.out.println("�Ķ����Դϴ�");
			break;
		case 3:
			System.out.println("�ʷϻ��Դϴ�.");
			break;
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			break;
		}

	}

	public void exercise2() { /*
								 * ���� �ΰ��� �����ȣ ���� 1���� �Է¹޾Ƽ� �����ȣ����(+,-,*,/)�� �ش��ϴ� ����� �����ϰ� ����ϼ���. ��, �� ���� ���ڸ�
								 * �Է��� ��� �����ڸ� �߸��Է��ϼ̽��ϴٸ� ����ϼ���.
								 */
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
		int a = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
		int b = sc.nextInt();
		System.out.print("��Ģ���� ��ȣ�� �Է��ϼ��� (+-*/������) : ");
		char c = sc.next().charAt(0);
		int result = 0;
		String d = null;
		switch (c) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = (a - b);
			break;
		case '*':
			result = (a * b);
			break;
		case '/':
			result = (a / b);
			break;
		default:
			d = "�����ڸ� �߸� �Է��ϼ̽��ϴ�";			
			break;
		}
		if (d != null) {
			System.out.println("��� : " + d);
		} else {
			System.out.println("��� : " + result);
		}

	}

	public void exercise3() {
		/*
		 * 1 ~ 12 ������ ���ڸ� �Է¹޾� �ش��ϴ� ���� ���� ������ ��¥�� ����ϼ���. �׿��� ���ڸ� �Է��� ��� 1 ~ 12 ������ ���ڸ�
		 * �Է��ϼ��並 ����ϼ���
		 * 
		 * 1�� ~ 12������ �� �ϳ��� �Է��ϼ��� : 3 �Է��Ͻ� ���� 31�ϱ����Դϴ�.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		int mon = sc.nextInt();

		switch (mon) {
		case 2:
			System.out.println(mon + "���� 28,29�ϱ��� �Դϴ�");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(mon + "���� 30�ϱ��� �Դϴ�");
			break;
		default:
			if (1 <= mon && mon <= 12) {
				System.out.println(mon + "���� 31�ϱ��� �Դϴ�");
				break;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				break;
			}

		}
	}
}
