package com.kh.exercise;

import java.util.Scanner;

public class Comtrol_Exercise {
	public void practice1() {
//		����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ���ڵ��� ��� ����ϼ���.
//		��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
//		���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���.
//		ex.
//		1�̻��� ���ڸ� �Է��ϼ��� : 4 1�̻��� ���ڸ� �Է��ϼ��� : 0
//		1 2 3 4 1 �̻��� ���ڸ� �Է����ּ���.

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();
			if (num >= 1)
				for (int i = 1; i <= num; i++) {
					System.out.print(i + "  ");
				}
			else {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			}
			System.out.println();
		}

	}

	public void practice2() {

//		����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���.
//		��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
//		ex.
//		1�̻��� ���ڸ� �Է��ϼ��� : 4 1�̻��� ���ڸ� �Է��ϼ��� : 0
//		4 3 2 1 1 �̻��� ���ڸ� �Է����ּ���.
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();
			if (num >= 1)
				for (int i = num; i >= 1; i--) {

					System.out.print(i + "  ");

				}
			else {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			}
			System.out.println();
		}

	}

	public void practice3() {
//		1���� ����ڿ��� �Է� ���� �������� �������� ���� for���� �̿��Ͽ� ����ϼ���.
//		ex.
//		������ �ϳ� �Է��ϼ��� : 8
//		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("������ �ϳ� �Է��ϼ��� : ");
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
//		����ڷκ��� �� ���� ���� �Է� �޾� �� ������ ���ڸ� ��� ����ϼ���.
//		���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���
		Scanner sc = new Scanner(System.in);

		int a = 0;
		while (a < 1) {
			System.out.print("ù���� ���� : ");
			a = sc.nextInt();
			if (a < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			}
		}
		int b = 0;
		while (b < 1) {
			System.out.print("�ι��� ���� : ");
			b = sc.nextInt();
			if (b < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			}
		}
		int min = (a < b) ? a : b;
		int max = (a < b) ? b : a;
		for (int i = min; i <= max; i++) {
			System.out.print(i + "  ");

		}
	}

	public void practice5() {
//		����ڷκ��� �Է� ���� ������ ���� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int dan = sc.nextInt();
		System.out.println("======= " + dan + "�� =======");
		for (int i = 1; i < 10; i++) {

			System.out.println(dan + " x " + i + " = " + (dan * i));
		}
	}

	public void practice6() {
//		����ڷκ��� �Է� ���� ������ �ܺ��� 9�ܱ��� ����ϼ���.
//		��, 9�� �ʰ��ϴ� ���ڰ� ������ ��9 ������ ���ڸ� �Է����ּ��䡱�� ����ϼ���1	
		Scanner sc = new Scanner(System.in);
		int dan = 0;
		do {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			dan = sc.nextInt();
			if (dan > 9 || dan == 0 || dan == 1) {
				System.out.println("2�̻� 9������ ���ڸ� �Է��ϼ���");
			}
		} while (dan > 9 || dan == 0 || dan == 1);

		for (int j = dan; j < 10; j++) {
			System.out.println("======= " + j + "�� =======");
			for (int i = 1; i < 10; i++) {

				System.out.println(j + " x " + i + " = " + (j * i));
			}
		}
	}

	public void practice7() {
//		���� �Է� : 4
//		*
//		**
//		***
//		****
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� : ");
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
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int st = sc.nextInt();
		for (int i = 0; i < st; i++) {
			for (int j = i; j < st; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice9() {
//		1���� ����ڿ��� �Է� ���� ������ �߿���
//		1) 2�� 3�� ����� ��� ����ϰ�
//		2) 2�� 3�� ������� ������ ����ϼ���.
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� : ");
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
//		���� �Է� : 4
//		   *
//		  **
//		 ***
//		****
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
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
//		 ���� �Է� : 3
//		 *
//		 **
//		 ***
//		 **
//		 *
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
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
//		���� �Է� : 4
//		   *
//		  ***
//		 *****
//		*******
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
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
//		 ���� �Է� : 5
//		 *****
//		 *   *
//		 *   *
//		 *   *
//		 *****
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
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
		System.out.print("���ڸ� �Է��ϼ��� :");
		int num = sc.nextInt();
		int j = 0;
		if (num < 2) {
			System.out.println("�߸��Է��ϼ̽��ϴ�");
		} // ifnum<2
		else if (num == 2) {
			System.out.println("�Ҽ��Դϴ�");
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					j++;
				}
			}
			if (j == 0) {
				System.out.println("�Ҽ��Դϴ�");
			} else {
				System.out.println("�Ҽ��� �ƴմϴ�");
			}
		}

	}// pra

	public void practice15() {
		int num = 0;
		int j = 0;
		while (num < 2) {
			Scanner sc = new Scanner(System.in);
			System.out.print("���ڸ� �Է��ϼ��� :");
			num = sc.nextInt();
			if (num < 2) {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
			}
		}
		if (num == 2) {
			System.out.println("�Ҽ��Դϴ�");
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					j++;
				}
			}
			if (j == 0) {
				System.out.println("�Ҽ��Դϴ�");
			} else {
				System.out.println("�Ҽ��� �ƴմϴ�");
			}
		}

	}

	public void practice16() {
//		2���� ����ڰ� �Է��� �������� �Ҽ��� ��� ����ϰ� �Ҽ��� ������ ����ϼ���.
//		��, �Է��� ���� 2���� ���� ��� ���߸� �Է��ϼ̽��ϴ�.���� ����ϼ���.
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int c = 0;
		while (num < 2) {
			System.out.print("���ڸ� �Է��ϼ��� :");
			num = sc.nextInt();
			if (num < 2) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
		System.out.print("�Ҽ��� : ");
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
		System.out.print("�Ҽ��� ������ " + c);
	}
}
// class
