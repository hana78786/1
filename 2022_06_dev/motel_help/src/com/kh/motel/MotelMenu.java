package com.kh.motel;

import java.util.Scanner;

public class MotelMenu {
	Scanner sc = new Scanner(System.in);
	Roomarr roomArr = new Roomarr();
	boolean [] room = roomArr.getRoom();
	
	public void roomCheck() {
		System.out.println("���� Ȯ���մϴ�.");
		for (int i = 0; i < room.length; i++) {
			String a = (room[i]==true) ? "����Ұ��մϴ�" : "����ֽ��ϴ�";	
			System.out.print((i + 1) + "�� ���� " + a);
			System.out.println();
		}
	}

	public void checkOut(Scanner sc) {
		System.out.println("������� üũ�ƿ� �ұ��?");
		int roomNum = sc.nextInt();
		if (roomNum > 10 || roomNum <= 0) {
			System.out.println("�߸������̽��ϴ�.");
		} else if (room[roomNum - 1] == false) {
			System.out.println("�� ���� ����ֽ��ϴ�.");

		} else {
			System.out.println("=====" + roomNum + "�� ���� üũ�ƿ��մϴ�.====");
			for (int i = 0; i < room.length; i++) {
				if (roomNum - 1 == i) {
					room[i] = false;
				}
			}
		}
		roomArr.setRoom(room);
	}

	public  void checkIn(Scanner sc) {
		System.out.println("������� üũ�� �ұ��?");
		int roomNum = sc.nextInt();
		if (roomNum > 10 || roomNum <= 0) {
			System.out.println("�߸������̽��ϴ�.");
		} else if (room[roomNum - 1] == true) {
			System.out.println("�̹� üũ�� �Ǿ��ֽ��ϴ�.");
		} else {
			System.out.println("====" + roomNum + "�� ���� üũ���մϴ�.====");
			for (int i = 0; i < room.length; i++) {
				if (roomNum - 1 == i) {
					room[i] = true;
				}
			}
		}
		roomArr.setRoom(room);
	}

	public void PrintMenu() {
		System.out.println("====���� ���� ���α׷�====");
		System.out.println("1. üũ��");
		System.out.println("2. üũ�ƿ�");
		System.out.println("3. �����Ȯ��");
		System.out.println("4. ����");
	}
}
