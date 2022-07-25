package com.kh.control;

public class Exam_ForDouble {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println("i의 값 : "+i);
				System.out.println("j의 값 : "+j);
				System.out.printf("%dX%d=%d",i,j,i*j);
				System.out.println();
				
			}
		}
	}
}
