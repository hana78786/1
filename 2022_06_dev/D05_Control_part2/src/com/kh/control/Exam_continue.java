package com.kh.control;

public class Exam_continue {
	public static void main(String[] args) {

		for (int i = 1; i <= 30; i++) {

			// 3�� ��� �Ǻ� i %3==0?
			// 3�� ��� ����
			if (i % 3 == 0)
				continue;
			System.out.print(i + " ");
		}
	}

}
