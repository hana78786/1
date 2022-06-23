package com.kh.interfaceex;

public interface Car {
// 인터페이스는 추상 클래스의 변형체
//추상클래스는 일반 변수, 메소드 선언가능하지만
// 인터페이스는 사수형 필드, 추상메소드만 가능하다.
	
//		public String carName;  //오류
//		public void stop() { 	//오류
//			
//		}
		String carName = "c차차차";
		void stop();
		void move(int x);
}
