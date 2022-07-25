package com.kh.dimarray;

public class Exercise_DimArray {
	public void exercise1() {
		// 5 4 3 2 1
		// 10 9 8 7 6
		// 15 14 13 12 11
		// 20 19 18 17 16
		// 25 24 23 22 21
		int[][] nums = new int[5][5];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums[i].length - 1; j >= 0; j--) {
				nums[i][j] = k;
				k++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.printf("%2d \t", nums[i][j]);
			}
			System.out.println();
		}

	}

	public void exercise2() {
		// 5 10 15 20 25
		// 4 9 14 19 24
		// 3 8 13 18 23
		// 2 7 12 17 22
		// 1 6 11 16 21
		int[][] nums = new int[5][5];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums[i].length - 1; j >= 0; j--) {
				nums[j][i] = k;
				k++;

			}
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.printf("%2d \t", nums[i][j]);
			}
			System.out.println();
		}

	}

	public void exercise3() {
		// 1 6 11 16 21
		// 2 7 12 17 22
		// 3 8 13 18 23
		// 4 9 14 19 24
		// 5 10 15 20 25
		int[][] nums = new int[5][5];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[j][i] = k;
				k++;

			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.printf("%2d \t", nums[i][j]);
			}
			System.out.println();
		}
	}

	public void exercise4() {
		// 1 2 3 4 5
		// 10 9 8 7 6
		// 11 12 13 14 15
		// 20 19 18 17 16
		// 21 22 23 24 25
		int[][] nums = new int[5][5];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < nums[i].length; j++) {
					nums[i][j] = k;
					k++;
				}
			} else {
				for (int j = nums[i].length - 1; j >= 0; j--) {
					nums[i][j] = k;
					k++;
				}

			}

		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.printf("%2d \t", nums[i][j]);
			}
			System.out.println();
		}
	}

}
