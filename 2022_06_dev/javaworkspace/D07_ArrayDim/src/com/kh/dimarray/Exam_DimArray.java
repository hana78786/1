package com.kh.dimarray;

import java.util.Random;

public class Exam_DimArray {
	public static void main(String[] args) {
		int[][] arrs = new int[4][4];
		Random rd=new Random();
		int k = rd.nextInt(15);
		// 4행 4열 배열의 0~15까지의 값으로 초기화
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs[i].length; j++) {
				arrs[i][j] = k;
				k++;
			}
		}
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs[i].length; j++) {
				System.out.printf("%2d | ", arrs[i][j]);
			}
			System.out.println();
		}
	}

}
