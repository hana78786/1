package com.kh.student;

import java.util.Scanner;

public class StudentRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentInfor sI = new StudentInfor();
		exit: while (true) {
			// �޴����
			sI.printmenu();
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: //�л������Է�
				sI.StuInput();
				break;
			case 2: //�л��������
				sI.printInfo();
				break;
			case 3: // ����
				System.out.println("�����մϴ�");
				break exit;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				break;
			}

		}
	}

}
