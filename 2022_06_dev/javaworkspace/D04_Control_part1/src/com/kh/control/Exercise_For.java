package com.kh.control;

import java.util.Scanner;

public class Exercise_For {
	public void exercise1() {
		// 1���� 100 ������ �ڿ��� �� Ȧ���� ���Ͽ� ����Ͻÿ�.
		int c = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				c += i;
			}
		}
		System.out.println(c);
	}

	public void exercise2() {
		// ������ �ϳ� �Է¹޾Ƽ� �� ���� 1 ~ 9������ ���� ����
		// �� ���� �������� ����Ͻÿ�.
		// ��, ������ ���� ������ "1 ~ 9 ������ ����� �Է��Ͽ����մϴ�"�� ����Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int a = sc.nextInt();
		if (a >= 1 && a <= 9) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(a + "X" + i + "=" + a * i);
			}
		} else {
			System.out.println("1~9������ ����� �Է��ϼ���");
		}

	}

	public void exercise3() {
		/*
		 * 1���� 10������ ������ ǥ���ϰ� �յ� ���Ͻÿ� 1+2+3+4+5+6+7+8+9+10=55
		 */
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			if (i != 10) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			}
		}
		System.out.print(sum);

	}
}
