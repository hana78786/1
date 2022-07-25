package com.kh.control;

public class Exam_continue {
	public static void main(String[] args) {

		for (int i = 1; i <= 30; i++) {

			// 3의 배수 판별 i %3==0?
			// 3의 배수 제외
			if (i % 3 == 0)
				continue;
			System.out.print(i + " ");
		}
	}

}
