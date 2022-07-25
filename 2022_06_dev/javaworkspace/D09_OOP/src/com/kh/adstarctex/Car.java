package com.kh.adstarctex;

public abstract class Car {  //abstract 추상 클래스 선언
		private String carName;
		
//		public void move(int x) {
//			System.out.println(x+"만큼 이동합니다");
//		}
		
		public abstract void move(int x);
		//abstract  추상메소드는 중괄호 쓰지 못함
		// 추상 메소드가 있는 클래스는 반드시 추상 클래스를 선언해야 함!


		public void stop() {
			System.out.println("차가 멈춥니다.");
		}
}
