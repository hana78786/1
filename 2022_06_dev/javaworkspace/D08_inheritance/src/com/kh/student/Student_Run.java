package com.kh.student;

import java.util.Scanner;

public class Student_Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ManageStudent mStu = new ManageStudent();
		Exit : while (true) {
			mStu.showMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				//�����Է�
				mStu.incertInfomation();
				break;
			case 2:
				//���� ���
				mStu.printResult();
				break;
			case 3:
				//����
				System.out.println("�����մϴ�");
				break Exit;
			default:
				//�Է¿���
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				break;
			}

		}
	}

}
