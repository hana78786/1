package com.kh.control;

import java.util.Scanner;

public class Exam_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ��� >");
		int num = sc.nextInt();
		if (num == 0) {
			System.out.println("0�Դϴ�");
		} else if (num > 0) {
			System.out.println("����Դϴ�");
		} else {
			System.out.println("�����Դϴ�");
		}
		String result = num == 0 ? "0�Դϴ�" : num > 0 ? "����Դϴ�" : "�����Դϴ�";

		if (num > 0) {
			System.out.println("����Դϴ�");

		}else if (num<0) {
			System.out.println("�����Դϴ�");
		
		}else {
			System.out.println("0�Դϴ�");
		}
	}
}
