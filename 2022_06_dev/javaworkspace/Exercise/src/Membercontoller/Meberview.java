package Membercontoller;

import java.util.Scanner;

public class Meberview {
Scanner scan = new Scanner(System.in);
	
	public int mainMenu() {

		System.out.println("======== ȸ������ ���α׷� =========");
		System.out.println("1. ȸ������ ��ü��ȸ");
		System.out.println("2. ȸ�� ���̵�� ��ȸ");
		System.out.println("3. ȸ�� �̸����� ��ȸ");
		System.out.println("4. ȸ�� ����");
		System.out.println("5. ȸ�� ���� ����");
		System.out.println("6. ȸ��Ż��");
		System.out.println("0. ���α׷� ����");
		System.out.print("��ȣ ���� :");
		int choice = scan.nextInt();
		return choice;

	}
}
