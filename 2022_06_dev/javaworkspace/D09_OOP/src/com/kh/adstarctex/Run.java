package com.kh.adstarctex;

public class Run {
	public static void main(String args[]) {
//		Car car = new Car(); //추상 클래스는 객체생성 불가
		Car car = new Sonata(); // 업캐스팅만 가능!
	car.move(5);
	}
}
