package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Logical2 {
	// �Է��� ���� ���� �빮������ Ȯ���Ͽ� ��� ����ϱ�
	// ���� �ϳ� �Է����ּ��� : a
	// ���� �빮�� Ȯ�� : false

	// ���� �ϳ� �Է����ּ��� : A
	// ���� �빮�� Ȯ�� : true
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϳ� �Է��ϼ���:");
		char alph = sc.next().charAt(0);
		boolean Bs= alph<=96 && alph>=65 ? true : false;
//		boolean Bs;
//		if (Character.isUpperCase(alph)) {
//			Bs = true;
//		} else {
//			Bs = false;
//		}
		System.out.print("���� �빮�� Ȯ�� :" + Bs);

	}

}
