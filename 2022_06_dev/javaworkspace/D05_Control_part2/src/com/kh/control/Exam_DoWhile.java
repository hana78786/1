package com.kh.control;

import java.util.Scanner;

public class Exam_DoWhile {
	public static void main(String[] args) {
		// �Է��� ���� -1�� �ɶ����� ~~ �Ͻÿ�.
		// -1�� �Է��� �ɶ����� �Է��� ���� ��� ���Ͽ� ����Ͻÿ�..
		// ���� �Է� : 2
		// ���� �Է� : 3
		// ���� �Է� : 4
		// ���� �Է� : -1
		// �Է��Ͻ� ���� ���� 9�Դϴ�.
		Scanner sc = new Scanner(System.in);
		int num=0;
		int sum=0;
		do {
			sum += num;
			System.out.print("�����Է�:");
			num=sc.nextInt();
		}
		while(num != -1);
		System.out.println("�Է��Ͻ� ���� ���� : "+sum);

	}
}
