package com.kh.motel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MotelMain {
	public static void main(String[] args) throws InputMismatchException {
		MotelMenu motelM = new MotelMenu();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		����: while (true) {
			motelM.PrintMenu();

			try {
				System.out.print("����  : ");
				choice = sc.nextInt();
				switch (choice) {
				case 1: // üũ��
					motelM.checkIn(sc);
					break;
				case 2: // üũ�ƿ�
					motelM.checkOut(sc);
					break;
				case 3: // ��üũ
					motelM.roomCheck();
					break;
				case 4: // ����
					System.out.println("�����մϴ�");
					break ����;
				default : System.out.println("�޴��� �ٽ� Ȯ�����ּ���");
				break;
				}
			} catch (InputMismatchException e) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				sc.next();
				continue;

			}
		}
	}

	

}
