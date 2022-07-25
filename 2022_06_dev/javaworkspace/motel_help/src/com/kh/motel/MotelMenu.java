package com.kh.motel;

import java.util.Scanner;

public class MotelMenu {
	Scanner sc = new Scanner(System.in);
	Roomarr roomArr = new Roomarr();
	boolean [] room = roomArr.getRoom();
	
	public void roomCheck() {
		System.out.println("방을 확인합니다.");
		for (int i = 0; i < room.length; i++) {
			String a = (room[i]==true) ? "예약불가합니다" : "비어있습니다";	
			System.out.print((i + 1) + "번 방은 " + a);
			System.out.println();
		}
	}

	public void checkOut(Scanner sc) {
		System.out.println("몇번방을 체크아웃 할까요?");
		int roomNum = sc.nextInt();
		if (roomNum > 10 || roomNum <= 0) {
			System.out.println("잘못누르셨습니다.");
		} else if (room[roomNum - 1] == false) {
			System.out.println("그 방은 비어있습니다.");

		} else {
			System.out.println("=====" + roomNum + "번 방을 체크아웃합니다.====");
			for (int i = 0; i < room.length; i++) {
				if (roomNum - 1 == i) {
					room[i] = false;
				}
			}
		}
		roomArr.setRoom(room);
	}

	public  void checkIn(Scanner sc) {
		System.out.println("몇번방을 체크인 할까요?");
		int roomNum = sc.nextInt();
		if (roomNum > 10 || roomNum <= 0) {
			System.out.println("잘못누르셨습니다.");
		} else if (room[roomNum - 1] == true) {
			System.out.println("이미 체크인 되어있습니다.");
		} else {
			System.out.println("====" + roomNum + "번 방을 체크인합니다.====");
			for (int i = 0; i < room.length; i++) {
				if (roomNum - 1 == i) {
					room[i] = true;
				}
			}
		}
		roomArr.setRoom(room);
	}

	public void PrintMenu() {
		System.out.println("====모텔 관리 프로그램====");
		System.out.println("1. 체크인");
		System.out.println("2. 체크아웃");
		System.out.println("3. 룸상태확인");
		System.out.println("4. 종료");
	}
}
