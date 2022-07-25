package com.kh.exercise;

import java.util.Scanner;

public class Exercise_If {
	public void exersize1() {
		// 키보드로 정수를 입력받고 입력받은 정수가 양수이고
		// 짝수일 때 "짝수다"를 출력하고 짝수가 아니면 "홀수다"를 출력하세요
		// 단, 양수가 아니면 "양수만 입력해주세요"를 출력하세요.

		// 정수하나 입력해주세요 : 4
		// 짝수다.

		// 정수하나 입력해주세요 : -2
		// 양수를 입력해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
//		if (num > 0) {
//			if (num % 2 == 0) {
//				System.out.println("짝수입니다");
//			} else {
//				System.out.println("홀수입니다");
//			}
//		} else {
//			System.out.println("양수를 입력하세요");
//
//		}
		if (num > 0 && num % 2 == 0) {
			System.out.println("짝수입니다");
		} else if (num < 0) {
			System.out.println("양수를 입력해주세요");
		} else if (num == 0) {
			System.out.println("0입니다.");
		} else if (num > 0 && num % 2 != 0) {
			System.out.println("홀수입니다");
		}
		sc.close();

	}

	public void exersize2() {
		/*
		 * 중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요. 평가비율은 중간고사 20%, 기말고사 30%,
		 * 과제 30%, 출석 100%로 이루어져있고 이 때, 출석 비율은 총 강의 회수 20회 중에서 출석한 날만 따진 값으로 계산 70점 이상일
		 * 경우 Pass(단, 출석횟수 충족), 70점 미만이거나 전체 강의의 30%이상 결석 시 Fail을 출력하세요.
		 * 
		 * 중간 고사 점수(20) : 70 기말 고사 점수(30) : 80 과제 점수 (30) : 77 출석 점수 (100) : 18
		 * 
		 * 총점 : 78 Pass입니다!
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수(20) : ");
		int middle = sc.nextInt();
		System.out.print("기말 고사 점수(30) : ");
		int end = sc.nextInt();
		System.out.print("과제 점수     (30) : ");
		int hw = sc.nextInt();
		System.out.print("출석 점수     (100) : ");
		int gw = sc.nextInt();

		double fin = middle * 0.2 + end * 0.3 + hw * 0.3 + gw;
		System.out.println("총점 : " + fin);
		if (fin >= 70 && gw > 20 * 0.7) {
			System.out.println("pass 입니다!");
		} else {
			if (gw <= 20 * 0.7 && fin < 70 ) {
				System.out.print("출석부족 (" + gw + "회 출석)으로 인해 ");
				System.out.print("동시에 70점을 넘지 못해서 (" + fin + "점) ");
			} else if (gw <= 20 * 0.7 ) {
				{
					System.out.print("출석부족 (" + gw + "회 출석)으로 인해 ");
				}
			} else {
				System.out.print("70점을 넘지 못해서 (" + fin + "점) ");
			}
			System.out.println("Fail");
		}

	}
}
