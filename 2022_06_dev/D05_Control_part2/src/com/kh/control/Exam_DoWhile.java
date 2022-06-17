package com.kh.control;

import java.util.Scanner;

public class Exam_DoWhile {
	public static void main(String[] args) {
		// 입력한 수가 -1이 될때까지 ~~ 하시오.
		// -1이 입력이 될때까지 입력한 수를 모두 합하여 출력하시오..
		// 정수 입력 : 2
		// 정수 입력 : 3
		// 정수 입력 : 4
		// 정수 입력 : -1
		// 입력하신 수의 합은 9입니다.
		Scanner sc = new Scanner(System.in);
		int num=0;
		int sum=0;
		do {
			sum += num;
			System.out.print("정수입력:");
			num=sc.nextInt();
		}
		while(num != -1);
		System.out.println("입력하신 수의 합은 : "+sum);

	}
}
