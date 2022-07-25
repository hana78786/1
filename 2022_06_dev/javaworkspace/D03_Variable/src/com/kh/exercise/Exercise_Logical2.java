package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Logical2 {
	// 입력한 문자 값이 대문자인지 확인하여 결과 출력하기
	// 문자 하나 입력해주세요 : a
	// 영어 대문자 확인 : false

	// 문자 하나 입력해주세요 : A
	// 영어 대문자 확인 : true
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자하나 입력하세요:");
		char alph = sc.next().charAt(0);
		boolean Bs= alph<=96 && alph>=65 ? true : false;
//		boolean Bs;
//		if (Character.isUpperCase(alph)) {
//			Bs = true;
//		} else {
//			Bs = false;
//		}
		System.out.print("영어 대문자 확인 :" + Bs);

	}

}
