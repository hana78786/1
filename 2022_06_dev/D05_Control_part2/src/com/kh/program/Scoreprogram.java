package com.kh.program;

import java.util.Scanner;

public class Scoreprogram {
	public static void main(String[] args) {
		/*
		 * ====== ���� �޴� ======= 1. �����Է� 2. ������� 3. ���� ���� : 1
		 * 
		 * ====== ���� �Է� ======= ���� : 50 ���� : 40 ���� : 30
		 * 
		 * 
		 * ====== ���� �޴� ======= 1. �����Է� 2. ������� 3. ���� ���� : 2
		 * 
		 * ====== ���� ��� ====== ���� : 50 ���� : 40 ���� : 30
		 * 
		 * ���� : 120 ��� : 40.00
		 * 
		 * ====== ���� �޴� ======= 1. �����Է� 2. ������� 3. ���� ���� : 3
		 * 
		 * Good Bye~
		 * 
		 */

		int ko = 0;
		int en = 0;
		int ma = 0;
		int i = 0;
		����: while (true) {
			System.out.println("==== ���θ޴� ====");
			System.out.println("1. �����Է�");
			System.out.println("2. �������");
			System.out.println("3. ����");
			System.out.print("���� : ");
			Scanner sc = new Scanner(System.in);
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				System.out.println("==== �����Է� ====");
				do {
					System.out.print("���� : ");
					ko = sc.nextInt();
					if (ko < 0 || ko > 100) {
						System.out.println("0~100���� ������ �Է��ϼ��� ");
					}
				} while (ko < 0 || ko > 100);
				do {
					System.out.print("���� : ");
					en = sc.nextInt();
					if (en < 0 || en > 100) {
						System.out.println("0~100���� ������ �Է��ϼ��� ");
					}
				} while (ko < 0 || en > 100);
				do {
					System.out.print("���� : ");
					ma = sc.nextInt();
					if (ma < 0 || ma > 100) {
						System.out.println("0~100���� ������ �Է��ϼ��� ");
					}
				} while (ma < 0 || ma > 100);
				i++;
				break;
			
			case 2:
				if (i == 0) {
					System.out.println("������ �Էµ��� �ʾҽ��ϴ�");
					break;
				} else {
					System.out.println("==== ���� ��� ====");
					System.out.println("���� : " + ko);
					System.out.println("���� : " + en);
					System.out.println("���� : " + ma);
					System.out.println();
					System.out.println("���� : " + (ko + en + ma));
					double va = (ko + en + ma) / 3;
					System.out.println("��� : " + va);
					break;
				}
			
			case 3:
				System.out.println("Good Bye~");
				break ����;
			
			default:
				System.out.println("�߸������̽��ϴ�");
			}// switch�� �߰�ȣ
		} // while true�� �߰�ȣ
	}
}
