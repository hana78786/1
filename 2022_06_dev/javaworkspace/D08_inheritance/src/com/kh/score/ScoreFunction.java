package com.kh.score;

import java.util.Scanner;

public class ScoreFunction {
	private int kor;
	private int eng;
	private int math;
	public void printMainMenu() {
		System.out.println("===== 메인메뉴 =====");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 종료");
		System.out.print("선택 : ");

	}

	public void insertScore() {
		System.out.println("성적을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 : ");
		kor = scanner.nextInt();
		System.out.print("영어 : ");
		eng = scanner.nextInt();
		System.out.print("수학 : ");
		math = scanner.nextInt();

	}

	public void printScore() {
		double total = kor + eng + math;
		double avg = total / 3;
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + total);
		System.out.println("평균 : "+ avg);

	}
}
