package com.kh.program;

import java.util.Scanner;

public class ScorProgram {
	static int kor = 0;
	static int eng = 0;
	static int math = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		종료: while (true) {
			printMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				incertScore();
				break;
			case 2:
				printScore();
				break;
			case 3:
				System.out.println("종료합니다.");
				sc.close();
				break 종료;
			default:
				System.out.println("잘못 입력하셨습니다");
				break;

			}
		}

	}

	static void printMainMenu() {
		System.out.println("===== 메인 메뉴 =====");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		System.out.println("선택 : ");
	
	}
	static void incertScore() {
		Scanner sc= new Scanner(System.in);
		System.out.println("===== 성적 입력 =====");
		System.out.println("국어성적 : ");
		kor = sc.nextInt();
		System.out.println("영어성적 : ");
		eng = sc.nextInt();
		System.out.println("수학성적 : ");
		math = sc.nextInt();
		
	}
	static void printScore() {
		System.out.println("==== 성적 출력 =====");
		System.out.println("국어성적 : " + kor);
		System.out.println("영어성적 : " + eng);
		System.out.println("수학성적 : " + math);
		int total = kor + eng + math;
		double avg = total / 3;
		System.out.println("총점 :" + total);
		System.out.println("평균 : " + avg);
	}
}
