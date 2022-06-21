package com.kh.exercise;

import java.util.Scanner;

public class Comtrol_Exercise {
	public void practice1() {
//		사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
//		단, 입력한 수는 1보다 크거나 같아야 합니다.
//		만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
//		ex.
//		1이상의 숫자를 입력하세요 : 4 1이상의 숫자를 입력하세요 : 0
//		1 2 3 4 1 이상의 숫자를 입력해주세요.

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
			if (num >= 1)
				for (int i = 1; i <= num; i++) {
					System.out.print(i + "  ");
				}
			else {
				System.out.println("1 이상의 숫자를 입력해주세요");
			}
			System.out.println();
		}

	}

	public void practice2() {

//		사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
//		단, 입력한 수는 1보다 크거나 같아야 합니다.
//		ex.
//		1이상의 숫자를 입력하세요 : 4 1이상의 숫자를 입력하세요 : 0
//		4 3 2 1 1 이상의 숫자를 입력해주세요.
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
			if (num >= 1)
				for (int i = num; i >= 1; i--) {

					System.out.print(i + "  ");

				}
			else {
				System.out.println("1 이상의 숫자를 입력해주세요");
			}
			System.out.println();
		}

	}

	public void practice3() {
//		1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
//		ex.
//		정수를 하나 입력하세요 : 8
//		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("정수를 하나 입력하세요 : ");
			int num = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;

				if (i != num) {
					System.out.print(i + " + ");
				} else {
					System.out.print(i + " = ");
					System.out.print(sum);
					System.out.println();
				}

			}
		}
	}

	public void practice4() {
//		사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
//		만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요
		Scanner sc = new Scanner(System.in);

		int a = 0;
		while (a < 1) {
			System.out.print("첫번재 숫자 : ");
			a = sc.nextInt();
			if (a < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요");
			}
		}
		int b = 0;
		while (b < 1) {
			System.out.print("두번재 숫자 : ");
			b = sc.nextInt();
			if (b < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요");
			}
		}
		int min = (a < b) ? a : b;
		int max = (a < b) ? b : a;
		for (int i = min; i <= max; i++) {
			System.out.print(i + "  ");

		}
	}

	public void practice5() {
//		사용자로부터 입력 받은 숫자의 단을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int dan = sc.nextInt();
		System.out.println("======= " + dan + "단 =======");
		for (int i = 1; i < 10; i++) {

			System.out.println(dan + " x " + i + " = " + (dan * i));
		}
	}

	public void practice6() {
//		사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
//		단, 9를 초과하는 숫자가 들어오면 “9 이하의 숫자만 입력해주세요”를 출력하세요1	
		Scanner sc = new Scanner(System.in);
		int dan = 0;
		do {
			System.out.print("숫자를 입력하세요 : ");
			dan = sc.nextInt();
			if (dan > 9 || dan == 0 || dan == 1) {
				System.out.println("2이상 9이하의 숫자만 입력하세요");
			}
		} while (dan > 9 || dan == 0 || dan == 1);

		for (int j = dan; j < 10; j++) {
			System.out.println("======= " + j + "단 =======");
			for (int i = 1; i < 10; i++) {

				System.out.println(j + " x " + i + " = " + (j * i));
			}
		}
	}

	public void practice7() {
//		정수 입력 : 4
//		*
//		**
//		***
//		****
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int st = sc.nextInt();
		for (int i = 0; i < st; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int st = sc.nextInt();
		for (int i = 0; i < st; i++) {
			for (int j = i; j < st; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice9() {
//		1부터 사용자에게 입력 받은 수까지 중에서
//		1) 2와 3의 배수를 모두 출력하고
//		2) 2와 3의 공배수의 개수를 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int j = 0;
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
			if (i % 2 == 0 && i % 3 == 0) {
				j++;
			}
		}
		System.out.println("count : " + j);
	}

	public void practice10() {
//		정수 입력 : 4
//		   *
//		  **
//		 ***
//		****
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num - (i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void practice11() {
//		 정수 입력 : 3
//		 *
//		 **
//		 ***
//		 **
//		 *
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int k = 0; k < num; k++) {
			for (int j = num; j > k + 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void practice12() {
//		정수 입력 : 4
//		   *
//		  ***
//		 *****
//		*******
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num - (i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void practice13() {
//		 정수 입력 : 5
//		 *****
//		 *   *
//		 *   *
//		 *   *
//		 *****
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				int j = 0;
				while (j < num) {
					System.out.print("*");
					j++;
				}
				for (int m = 2; m < num; m++) {
					System.out.println();
					System.out.print("*");
					for (int l = 0; l < num - 2; l++) {
						System.out.print(" ");
					}
					System.out.print("*");
				}
				System.out.println();
			}
			if (i == num - 1) {
				int k = 0;
				while (k < num) {
					System.out.print("*");
					k++;
				}
			}

		}

	}

	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 :");
		int num = sc.nextInt();
		int j = 0;
		if (num < 2) {
			System.out.println("잘못입력하셨습니다");
		} // ifnum<2
		else if (num == 2) {
			System.out.println("소수입니다");
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					j++;
				}
			}
			if (j == 0) {
				System.out.println("소수입니다");
			} else {
				System.out.println("소수가 아닙니다");
			}
		}

	}// pra

	public void practice15() {
		int num = 0;
		int j = 0;
		while (num < 2) {
			Scanner sc = new Scanner(System.in);
			System.out.print("숫자를 입력하세요 :");
			num = sc.nextInt();
			if (num < 2) {
				System.out.println("잘못입력하셨습니다");
			}
		}
		if (num == 2) {
			System.out.println("소수입니다");
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					j++;
				}
			}
			if (j == 0) {
				System.out.println("소수입니다");
			} else {
				System.out.println("소수가 아닙니다");
			}
		}

	}

	public void practice16() {
//		2부터 사용자가 입력한 수까지의 소수를 모두 출력하고 소수의 개수를 출력하세요.
//		단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int c = 0;
		while (num < 2) {
			System.out.print("숫자를 입력하세요 :");
			num = sc.nextInt();
			if (num < 2) {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		System.out.print("소수는 : ");
		for (int i = 2; i <= num; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0 && i != j) {
					break;
				}
				if (i == j) {
					System.out.print(+i+" ");
					c++;
				}
			}
		}
		System.out.print("소수의 갯수는 " + c);
	}
}
// class
