package com.kh.exscanner;

import java.util.Scanner;

public class TestScanner2 {
	public static void main(String[] args) {
		// 입력받은 것 중에서 정수를 입력받았습니다.
		// 실수, 문자, 문자열

		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 >>");
		int iNum = sc.nextInt();
		System.out.println("실수를 입력하세요>>");
		double dNum = sc.nextDouble();
		System.out.println("문자열을 입력하세요>>");
		String inputStr = sc.next();
		System.out.println("문자를 입력하세요>>");
		char inputChar = sc.next().charAt(0);
		System.out.println("정수:" + iNum);
		System.out.println("실수:" + dNum);
		System.out.println("문자열:" + inputStr);
		System.out.println("문자:" + inputChar);
	}
}