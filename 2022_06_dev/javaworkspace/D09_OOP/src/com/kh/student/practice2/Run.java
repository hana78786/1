package com.kh.student.practice2;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		// 0. ��ĳ�� �ҷ����� + �ν��Ľ� �����
		Scanner scan = new Scanner(System.in);
		// ���⿡ consol�ν��Ľ�!
		Consol consol = new Consol();
		// 1. ���Ϲ����� �޴�
		exit: while (true) {
			consol.printMenu();
			String sel = scan.next();
			// 2. ���Ϲ��ȿ��� ����ġ �޴�
			switch (sel) {
			case "1":
				//�Է¸޴�
				consol.inputStudent();
				break;
			case "2":
				//��¸޴�
				consol.printStudent();
				break;
			case "3":
				System.out.println("�����մϴ�");
				break exit;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}

	}

}
