package com.kh.student.practice;

import java.util.Scanner;

public class StudentRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentConsol sc = new StudentConsol();
		// 1 �޴������ֱ�(���ѹݺ�)
		exit: while (true) {
			//�޴��޼ҵ� �ҷ�����!
			sc.printmenu();
			int sel= scanner.nextInt();
			switch (sel) {
			case 1:
				sc.inputImpo();
				break;
			case 2:
				sc.printImpo();
				break;
			case 3:System.out.println("�����մϴ�");
				break exit;
			default:System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
			// 2.�Է¹ޱ�
			// 3.����ϱ�
			// 4.����޴� �����Խ� �����޼��� ���
		}

	}

}
