package com.kh.operator;

import java.util.Scanner;

public class Exam_Triple {
	public static void main(String[] args) {
		/*
		 * ���׿����� �׸��� 3�� (���ǽ�) ? ���϶� : �����϶� -���ǽ��� �ݵ�� true or false -��/�������� �ַ� ���
		 * 
		 */
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		String resultStr;
		resultStr = num % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println(num+"��/�� "+resultStr+"�Դϴ�");
	}
}
