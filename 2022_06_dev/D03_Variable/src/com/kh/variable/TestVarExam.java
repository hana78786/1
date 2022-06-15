package com.kh.variable;

public class TestVarExam {
	public static void main(String[] args) {
		// 자료형 별 변수 만들고 초기화 한 후 그 값을 출력한다.(System.out.printnln)
		int iNum = 100;
		long lNum = 999900000000l;
		float fNum = 486.520f;
		double dNum = 567.890123;
		char fcahr = 'A';
		String fStr = "Hello world";
		boolean result = false;

		System.out.println("정수 값 : " + iNum); // ""+를 사용하여 문자열과 변수를 동시에 출력할수있다.
		System.out.println("정수의 값(9999억이상) : " + lNum);
		System.out.println("실수의 값 : " + fNum);
		System.out.println("실수의 값 : " + dNum);
		System.out.println("문자의 값 : " + fcahr);
		System.out.println("문자열의 값 : " + fStr);
		System.out.println("논리의 값 : " + result);
		System.out.println();
		System.out.println(1 + 1);
		System.out.println(1.1 + 1.1);
		System.out.println('a' + 'a');
		System.out.println("1" + "1");
		System.out.println();
		System.out.println("Hello" + 'q'); //Helloq
		System.out.println("Hello" + 10); //Hello10
		System.out.println("Hello" + 3.14); //Hello3.14
		System.out.println(10 + "Hello"); //10 Hello
		System.out.println(10 + 20 + "Hello"); // 30Hello
		System.out.println(10 + (20 + "Hello")); //1020Hello
		System.out.println(10 + "Hello" + 20); //10Hello20
		System.out.println();
		System.out.println(10 + 'h' + 20);
	}

}
