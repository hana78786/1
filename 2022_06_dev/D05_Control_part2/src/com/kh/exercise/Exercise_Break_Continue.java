package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Break_Continue {
	public void exersize1() {
		// ���� �ϳ��� �Է� ���� ��
		// 1���� �Է��� ���ڱ����� ���� ����Ͻÿ�
		/*
		 * ���� �ϳ� �Է��ϼ��� : 5 1���� 5������ �� : 15
		 */
		// 1+2+3+4+5
		// 1���� 1�� �����ϸ鼭 �ݺ��Ͽ� �����ش�.

		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int sum = 0;
		int i = 1;
		while (true) {
			sum += i;
			if (i == num) {
				break;
			}
			i++;
		}
		System.out.print("1���� " + num + "������ �� : " + sum);

	}

	public void exersize2() {
		/*
		 * 1���� 100������ �������� ���� ����ϴµ� 4�� ����� ���� ���Ͽ� ����Ͻÿ�.
		 * 
		 */
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				continue;
			}
			sum += i;
		}

		System.out.println(sum);

	}

	public void exersize3() {

	}
}
