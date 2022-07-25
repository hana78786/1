package com.kh.student.practice4;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		// 스캐너 불러오기
		Scanner scan = new Scanner(System.in);
		// 인스탠스 입력하기
		Consol consol = new Consol();
		// 와일문만들기
		exit: while (true) {
			// 메뉴프린트하기
			consol.printMenu();
			// 스위치만들기
			int sel = scan.nextInt();
			switch (sel) {
			case 1:
				consol.inputStudent();
				break;
			// 입력창
			case 2:
				consol.printStudent();
				break;
			// 출력창
			case 3:
				System.out.println("종료합니다");
				break exit;

			default:
				System.out.println("오류");
				break;

			}
		}
	}

}
