package com.kh.exercise;

public class Exercise_ForDouble {
	public void exercise1() {
		// 0시 0분부터 23시 59분까지 출력하기!
		// 0시 0분
		// 0시 1분
		// 0시 2분
		// ...

		// 1시 0분
		// 1시 1분
		// ...

		// 23시 58분
		// 23시 59분

		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++)
				System.out.println(i + "시" + j + "분");

		}

	}

	public void exercise2() {
		// *
		// **
		// ***
		// ****
		// *****
		// ******
		// *******
		// ********
		// *********
		// **********
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void exercise3() {
		// 구구단을 출력하되(\t)
		// 2단 옆에 3단, 3단 옆에 4단, 4단 옆에 5단 ...
		// 2 * 1 = 2 3 * 1 = 3 4 * 1 = 4
		// 2 * 2 = 2 3 * 2 = 6 4 * 2 = 8
		// ...
		// 2 * 9 = 18 3 * 9 = 27 4 * 9 = 36

		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.printf("%d * %d = %d  \t",j, i, j*i);
			}
			System.out.println();
		}

	}

}
