package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Trip1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("������ �Է����ּ���: ");
		int a= sc.nextInt();
		String a1= a<0 ? "����" :( (a==0) ? "0" : "���");
		System.out.println(a+"��/�� "+a1+"�Դϴ�.");
		
	}
	// �Է¹��� ������ ���, 0, �������� �Ǻ� �� ����ϼ���..
	// �ʹ� ������ ���, ���� �Ǻ����� �غ�����
	// ������ �Է����ּ��� : -1
	// -1��/�� �����Դϴ�.

	// ������ �Է����ּ��� : 1
	// 1��/�� ����Դϴ�.

	// ������ �Է����ּ��� : 0
	// 0��/�� 0�Դϴ�.

}
