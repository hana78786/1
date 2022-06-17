package com.kh.program;

import java.util.Scanner;

public class Scoreprogram {
	public static void main(String[] args) {
		/*
		 * ====== 메인 메뉴 ======= 1. 성적입력 2. 성적출력 3. 종료 선택 : 1
		 * 
		 * ====== 성적 입력 ======= 국어 : 50 영어 : 40 수학 : 30
		 * 
		 * 
		 * ====== 메인 메뉴 ======= 1. 성적입력 2. 성적출력 3. 종료 선택 : 2
		 * 
		 * ====== 성적 출력 ====== 국어 : 50 영어 : 40 수학 : 30
		 * 
		 * 총점 : 120 평균 : 40.00
		 * 
		 * ====== 메인 메뉴 ======= 1. 성적입력 2. 성적출력 3. 종료 선택 : 3
		 * 
		 * Good Bye~
		 * 
		 */

		int ko = 0;
		int en = 0;
		int ma = 0;
		int i = 0;
		종료: while (true) {
			System.out.println("==== 메인메뉴 ====");
			System.out.println("1. 성적입력");
			System.out.println("2. 성적출력");
			System.out.println("3. 종료");
			System.out.print("선택 : ");
			Scanner sc = new Scanner(System.in);
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				System.out.println("==== 성적입력 ====");
				do {
					System.out.print("국어 : ");
					ko = sc.nextInt();
					if (ko < 0 || ko > 100) {
						System.out.println("0~100안의 점수를 입력하세요 ");
					}
				} while (ko < 0 || ko > 100);
				do {
					System.out.print("영어 : ");
					en = sc.nextInt();
					if (en < 0 || en > 100) {
						System.out.println("0~100안의 점수를 입력하세요 ");
					}
				} while (ko < 0 || en > 100);
				do {
					System.out.print("수학 : ");
					ma = sc.nextInt();
					if (ma < 0 || ma > 100) {
						System.out.println("0~100안의 점수를 입력하세요 ");
					}
				} while (ma < 0 || ma > 100);
				i++;
				break;
			
			case 2:
				if (i == 0) {
					System.out.println("성적이 입력되지 않았습니다");
					break;
				} else {
					System.out.println("==== 성적 출력 ====");
					System.out.println("국어 : " + ko);
					System.out.println("영어 : " + en);
					System.out.println("수학 : " + ma);
					System.out.println();
					System.out.println("총점 : " + (ko + en + ma));
					double va = (ko + en + ma) / 3;
					System.out.println("평균 : " + va);
					break;
				}
			
			case 3:
				System.out.println("Good Bye~");
				break 종료;
			
			default:
				System.out.println("잘못누르셨습니다");
			}// switch의 중괄호
		} // while true의 중괄호
	}
}
