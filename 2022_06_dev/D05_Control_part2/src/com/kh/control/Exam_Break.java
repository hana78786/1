package com.kh.control;

import java.util.Scanner;

public class Exam_Break {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("0. 종료");
		a:
		while (true) {
			System.out.print("메뉴 번호를 입력하세요 : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("입력메뉴입니다.");
				break;
			case 2:
				System.out.println("수정메뉴입니다.");
				break;
			case 3:
				System.out.println("조회메뉴입니다");
				break;
			case 4:
				System.out.println("삭제메뉴입니다");
				break;
			case 0:
				System.out.println("종료합니다");
				break a;
			default :
				System.out.println("잘못입력하셨습니다");
				break;
			}

		}
	}
}
