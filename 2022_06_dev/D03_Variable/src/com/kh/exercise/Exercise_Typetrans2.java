package com.kh.exercise;

public class Exercise_Typetrans2 {
	public static void main(String[] args) {
		int iNum1 = 3;
		double iNum2 = 2;//�ڵ�����ȯ
		int result = (int) (iNum1 + iNum2); //iNum1�� iNum2�� Ÿ���� �޶� ����� ���� �ʾƾ� ������ int�� double�� �ڵ� ��ȯ�Ǿ� ���ȴ�.
		System.out.println(result);
		System.out.println((int)result); //()�ȿ� ��ȯ�ϰ��� �ϴ� Ÿ���� ���� ����ȯ�� �Ҽ��ִ� ���� ����ȯ
	}

}
