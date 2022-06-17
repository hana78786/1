package com.kh.exercise;

public class Exercise_ForDouble {
	public void exercise1() {
		// 0�� 0�к��� 23�� 59�б��� ����ϱ�!
		// 0�� 0��
		// 0�� 1��
		// 0�� 2��
		// ...

		// 1�� 0��
		// 1�� 1��
		// ...

		// 23�� 58��
		// 23�� 59��

		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++)
				System.out.println(i + "��" + j + "��");

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
		// �������� ����ϵ�(\t)
		// 2�� ���� 3��, 3�� ���� 4��, 4�� ���� 5�� ...
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
