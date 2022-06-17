package com.kh.control;

import java.util.Scanner;

public class Exa_Break1 {
	public static void main(String[] args) {
		// 문자열을 입력받아 글자 개수를 출력하는 프로그램인데
		// "end"가 입력되면 반복을 종료함.
		// 무한반복
		// end가 입력되면 종료하기
		// while로 무한반복하기! - while(true){}
		// for로 무한반복하기 - for(조건문안씀;;안씀) 그럼 무한반복됨 (;;)만쓰자!
		while (true) {
			System.out.println("문자열을 입력하세요");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			// input이 end일때 종료
			if (input.equals("end")){ //input=="end"  이건 실행되지 않음! 문자열은 .equals("문자열")만 가능!
				break;
			}
			System.out.println ("문자열의 길이" + input.length());
		}

	}
}
