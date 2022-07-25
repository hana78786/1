package com.kh.control;

import java.util.Scanner;

public class Exercise_For {
	public void exercise1() {
		// 1에서 100 사이의 자연수 중 홀수만 더하여 출력하시오.
		int c = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				c += i;
			}
		}
		System.out.println(c);
	}

	public void exercise2() {
		// 정수를 하나 입력받아서 그 수가 1 ~ 9사이의 수일 때만
		// 그 수의 구구단을 출력하시오.
		// 단, 조건이 맞지 않으면 "1 ~ 9 사이의 양수를 입력하여야합니다"를 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int a = sc.nextInt();
		if (a >= 1 && a <= 9) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(a + "X" + i + "=" + a * i);
			}
		} else {
			System.out.println("1~9사이의 양수를 입력하세요");
		}

	}

	public void exercise3() {
		/*
		 * 1부터 10까지의 덧셈을 표시하고 합도 구하시오 1+2+3+4+5+6+7+8+9+10=55
		 */
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			if (i != 10) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			}
		}
		System.out.print(sum);

	}
}
