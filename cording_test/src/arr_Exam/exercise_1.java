package arr_Exam;

import java.util.Scanner;

public class exercise_1 {

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