package com.kh.control;

import java.util.Scanner;

public class Exam_Break {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("0. ����");
		a:
		while (true) {
			System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("�Է¸޴��Դϴ�.");
				break;
			case 2:
				System.out.println("�����޴��Դϴ�.");
				break;
			case 3:
				System.out.println("��ȸ�޴��Դϴ�");
				break;
			case 4:
				System.out.println("�����޴��Դϴ�");
				break;
			case 0:
				System.out.println("�����մϴ�");
				break a;
			default :
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				break;
			}

		}
	}
}
