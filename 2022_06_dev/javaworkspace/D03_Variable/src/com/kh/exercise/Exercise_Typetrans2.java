package com.kh.exercise;

public class Exercise_Typetrans2 {
	public static void main(String[] args) {
		int iNum1 = 3;
		double iNum2 = 2;//자동형변환
		int result = (int) (iNum1 + iNum2); //iNum1과 iNum2가 타입이 달라 계산이 되지 않아야 하지만 int가 double로 자동 변환되어 계산된다.
		System.out.println(result);
		System.out.println((int)result); //()안에 변환하고자 하는 타입을 적어 형변환을 할수있다 강제 형번환
	}

}
