package com.kh.method;

import com.kh.exercise.Exercise_Method;

public class ExamMethod {
	public static void main(String[] args) {
		Exercise_Method exMethod = new Exercise_Method();
		exMethod.calcNumPrint();
		System.out.println("매개변수가 없고 반환형이 잇는 매소드의 리턴값 : " +exMethod.calcNum());
		exMethod.calcNumPrint(500);
		System.out.println("매개변수가 있고 반환형도 있는 메소드의 반환값 : "+ exMethod.calcNum(500));
	}

}
