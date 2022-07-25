package com.kh.exercise;

public class Exercise_Method {
	public void calcNumPrint() {
		System.out.println("매개변수가 없고 반환형이 없는 메소드 출력");
	}
	public int calcNum() {
		return 5;// 배개 변수가 없고 반환형은 있는 메소드
	}
	
	public void calcNumPrint(int x) {
		//int x = 500;
		System.out.println("매개변수가 있고반환형이 없는 메소드의 매개변수값 : " + x);
	}
	public int calcNum(int input) {
		return input+500;
	}
}
