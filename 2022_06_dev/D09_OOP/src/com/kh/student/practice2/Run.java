package com.kh.student.practice2;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		// 0. 스캐너 불러오기 + 인스탠스 만들기
		Scanner scan = new Scanner(System.in);
		// 여기에 consol인스탠스!
		Consol consol = new Consol();
		// 1. 와일문으로 메뉴
		exit: while (true) {
			consol.printMenu();
			String sel = scan.next();
			// 2. 와일문안에서 스위치 메뉴
			switch (sel) {
			case "1":
				//입력메뉴
				consol.inputStudent();
				break;
			case "2":
				//출력메뉴
				consol.printStudent();
				break;
			case "3":
				System.out.println("종료합니다");
				break exit;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}

	}

}
