package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Triple2 {
	// 두 수와 '+' 또는 '-'를 입력받아 알맞은 계산 결과 출력하기
	// 단, '+', '-' 이외의 연산자 입력시 "잘못입력하셨습니다!" 출력

	// 첫번째 수 : 6
	// 두번째 수 : 12
	// 연산자 입력(+ or -) : +
	// 결과 : 18

	// 첫번째 수 : 6
	// 두번째 수 : 12
	// 연산자 입력(+ or -) : -
	// 결과 : -6
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 : ");
		int a = sc.nextInt();
		System.out.print("두번째 수 : ");
		int b = sc.nextInt();
		System.out.print("연산자 입력 ( + or -): ");
		char c = sc.next().charAt(0);
		String f="잘못입력하셨습니다";
		int g = a+b;
		int h = a-b;
		String  e = c == '+' ? g+"" : (c=='-' ? h+"" : f);
		
		System.out.println("결과는 : "+e);

	}
}
