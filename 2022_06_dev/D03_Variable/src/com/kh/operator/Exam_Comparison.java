package com.kh.operator;

public class Exam_Comparison {
	public static void main(String[] args) {
		System.out.println("비교연산자 예제");
		int a = 50;
		int b = 30;
		boolean result = a < b;
		System.out.println("(a<b)의 결과 : " + result);
		result = a > b;
		System.out.println("(a>b)의 결과 : " + result);
		result = (a == b);
		System.out.println("(a==b)의 결과 : " + result);
		result = (a != b);
		System.out.println("(a != b)의 결과 : " + result);
		
		int num =2;
		result = (num/2==1);
		System.out.println("짝수인가 : "+ result);
	}

}
