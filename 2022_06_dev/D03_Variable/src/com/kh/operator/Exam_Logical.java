package com.kh.operator;

public class Exam_Logical {
	public static void main(String[] args) {
		System.out.println("논리연산자 예제");
		int a = 50;
		int b = 30;
		boolean result1, result2, result3, result4;
		result1 = (a != b) && (a<b); //true and fase -> false
		result2 = (a < b) || (a==b); //false or fasle -> false
		result3 = (a > b) && (a!=b); //true and true, -> true
		result4 = (a > b) || (a==b); //true or false->true
		System.out.println("result1 : "+result1);
		System.out.println("resutl2 : "+result2);
		System.out.println("result3 : "+result3);
		System.out.println("result4 : "+result4);
		System.out.println();
		System.out.println("논리연산자 예제2");
		 a=70;
		 b=55;
		result1 = a==b || a++<100; // false or true / true
		result2 = a<b && --b <55; // false and true / false
		result3 = a!=b && b-- < a++; // true and true/ true
		result4= a++ != b || b++ >=85; // true or false/ true
		System.out.println("result1 : "+result1);
		System.out.println("resutl2 : "+result2);
		System.out.println("result3 : "+result3);
		System.out.println("result4 : "+result4);
		System.out.println("a : "+a+", b : "+b);

		
	}
}
