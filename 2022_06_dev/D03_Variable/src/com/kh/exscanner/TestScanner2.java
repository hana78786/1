package com.kh.exscanner;

import java.util.Scanner;

public class TestScanner2 {
	public static void main(String[] args) {
		// �Է¹��� �� �߿��� ������ �Է¹޾ҽ��ϴ�.
		// �Ǽ�, ����, ���ڿ�

		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� >>");
		int iNum = sc.nextInt();
		System.out.println("�Ǽ��� �Է��ϼ���>>");
		double dNum = sc.nextDouble();
		System.out.println("���ڿ��� �Է��ϼ���>>");
		String inputStr = sc.next();
		System.out.println("���ڸ� �Է��ϼ���>>");
		char inputChar = sc.next().charAt(0);
		System.out.println("����:" + iNum);
		System.out.println("�Ǽ�:" + dNum);
		System.out.println("���ڿ�:" + inputStr);
		System.out.println("����:" + inputChar);
	}
}