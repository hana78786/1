package com.kh.adstarctex;

public class Sonata extends Car{

	@Override
	public void move(int x) {
	//추상클래스 Car class에 추상메소드인 move는 추상메소드이기에
	//아무값이 없다, 그 경우 상속받은 자식 클래스는
	//아무값이 없는 추상메소드를 오버라이딩해 내용을 채워주어야 한다.
		System.out.println("Sonata가"+ x +"만큼 이동합니다.");
		
	}

}
