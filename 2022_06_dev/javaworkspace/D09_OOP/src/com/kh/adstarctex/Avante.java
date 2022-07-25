package com.kh.adstarctex;

public class Avante extends Car {

	@Override
	public void move(int x) {
	//추상클래스를 사용하면 {}가 없는 추상메소드의 내용을 추가해줘야한다
	//그렇기때문에 추상클래스를 상속했을때는 추상메소드를 오버라이드 해야한다!
	System.out.println("Avante가"+ x + "만큼 이동합니다.");	
	}
	

}
