package com.kh.student.practice4;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		// ��ĳ�� �ҷ�����
		Scanner scan = new Scanner(System.in);
		// �ν��Ľ� �Է��ϱ�
		Consol consol = new Consol();
		// ���Ϲ������
		exit: while (true) {
			// �޴�����Ʈ�ϱ�
			consol.printMenu();
			// ����ġ�����
			int sel = scan.nextInt();
			switch (sel) {
			case 1:
				consol.inputStudent();
				break;
			// �Է�â
			case 2:
				consol.printStudent();
				break;
			// ���â
			case 3:
				System.out.println("�����մϴ�");
				break exit;

			default:
				System.out.println("����");
				break;

			}
		}
	}

}
