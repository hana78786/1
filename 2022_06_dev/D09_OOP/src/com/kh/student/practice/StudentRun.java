package com.kh.student.practice;

import java.util.Scanner;

public class StudentRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentConsol sc = new StudentConsol();
		// 1 메뉴보여주기(무한반복)
		exit: while (true) {
			//메뉴메소드 불러오기!
			sc.printmenu();
			int sel= scanner.nextInt();
			switch (sel) {
			case 1:
				sc.inputImpo();
				break;
			case 2:
				sc.printImpo();
				break;
			case 3:System.out.println("종료합니다");
				break exit;
			default:System.out.println("잘못입력하셨습니다.");
				break;
			}
			// 2.입력받기
			// 3.출력하기
			// 4.종료메뉴 오기입시 오류메세지 출력
		}

	}

}
