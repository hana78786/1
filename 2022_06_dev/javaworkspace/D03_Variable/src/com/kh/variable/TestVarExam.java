package com.kh.variable;

public class TestVarExam {
	public static void main(String[] args) {
		// �ڷ��� �� ���� ����� �ʱ�ȭ �� �� �� ���� ����Ѵ�.(System.out.printnln)
		int iNum = 100;
		long lNum = 999900000000l;
		float fNum = 486.520f;
		double dNum = 567.890123;
		char fcahr = 'A';
		String fStr = "Hello world";
		boolean result = false;

		System.out.println("���� �� : " + iNum); // ""+�� ����Ͽ� ���ڿ��� ������ ���ÿ� ����Ҽ��ִ�.
		System.out.println("������ ��(9999���̻�) : " + lNum);
		System.out.println("�Ǽ��� �� : " + fNum);
		System.out.println("�Ǽ��� �� : " + dNum);
		System.out.println("������ �� : " + fcahr);
		System.out.println("���ڿ��� �� : " + fStr);
		System.out.println("���� �� : " + result);
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
