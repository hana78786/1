package com.kh.polymorphism;

public class Car {
	protected String carName;
	public void move(int x) {
		System.out.println(x+"만큼 이동합니다");
	}
	public void stop() {
		System.out.println("멈춥니다");
	}

}
