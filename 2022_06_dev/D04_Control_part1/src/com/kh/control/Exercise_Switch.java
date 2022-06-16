package com.kh.control;

import java.util.Scanner;

public class Exercise_Switch {
	public void exercise1() {
		// 1 ~ 3 사이의 정수를 입력받아
		// 1인 경우 빨간색 입니다.
		// 2인 경우 파란색입니다.
		// 3인 경우 초록색입니다.
		// 그외의 정수를 입력할 경우 잘못입력하셨습니다를 출력하세요.
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~3사이에 숫자를 입력해주세요 : ");
		int menu = scanner.nextInt();
		switch (menu) {
		case 1:
			System.out.println("빨간색입니다");
			break;
		case 2:
			System.out.println("파란색입니다");
			break;
		case 3:
			System.out.println("초록색입니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다");
			break;
		}

	}

	public void exercise2() { /*
								 * 정수 두개와 연산기호 문자 1개를 입력받아서 연산기호문자(+,-,*,/)에 해당하는 계산을 수행하고 출력하세요. 단, 그 외의 문자를
								 * 입력할 경우 연산자를 잘못입력하셨습니다를 출력하세요.
								 */
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int a = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요 : ");
		int b = sc.nextInt();
		System.out.print("사칙연산 부호를 입력하세요 (+-*/만가능) : ");
		char c = sc.next().charAt(0);
		int result = 0;
		String d = null;
		switch (c) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = (a - b);
			break;
		case '*':
			result = (a * b);
			break;
		case '/':
			result = (a / b);
			break;
		default:
			d = "연산자를 잘못 입력하셨습니다";			
			break;
		}
		if (d != null) {
			System.out.println("결과 : " + d);
		} else {
			System.out.println("결과 : " + result);
		}

	}

	public void exercise3() {
		/*
		 * 1 ~ 12 사이의 숫자를 입력받아 해당하는 숫자 달의 마지막 날짜를 출력하세요. 그외의 숫자를 입력할 경우 1 ~ 12 사이의 숫자를
		 * 입력하세요를 출력하세요
		 * 
		 * 1월 ~ 12월까지 중 하나를 입력하세요 : 3 입력하신 월은 31일까지입니다.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요");
		int mon = sc.nextInt();

		switch (mon) {
		case 2:
			System.out.println(mon + "월은 28,29일까지 입니다");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(mon + "월은 30일까지 입니다");
			break;
		default:
			if (1 <= mon && mon <= 12) {
				System.out.println(mon + "월은 31일까지 입니다");
				break;
			} else {
				System.out.println("잘못입력하셨습니다");
				break;
			}

		}
	}
}
