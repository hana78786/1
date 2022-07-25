package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Break_Continue {
	public void exersize1() {
		// 정수 하나를 입력 받은 후
		// 1부터 입력한 숫자까지의 합을 출력하시오
		/*
		 * 숫자 하나 입력하세요 : 5 1부터 5까지의 합 : 15
		 */
		// 1+2+3+4+5
		// 1부터 1씩 증가하면서 반복하여 더해준다.

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		int i = 1;
		while (true) {
			sum += i;
			if (i == num) {
				break;
			}
			i++;
		}
		System.out.print("1부터 " + num + "까지의 합 : " + sum);

	}

	public void exersize2() {
		/*
		 * 1부터 100까지의 정수들의 합을 출력하는데 4의 배수는 빼고 더하여 출력하시오.
		 * 
		 */
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				continue;
			}
			sum += i;
		}

		System.out.println(sum);

	}

	public void exersize3() {

	}
}
