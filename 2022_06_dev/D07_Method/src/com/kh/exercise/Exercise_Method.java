package com.kh.exercise;

public class Exercise_Method {
	public void calcNumPrint() {
		System.out.println("�Ű������� ���� ��ȯ���� ���� �޼ҵ� ���");
	}
	public int calcNum() {
		return 5;// �谳 ������ ���� ��ȯ���� �ִ� �޼ҵ�
	}
	
	public void calcNumPrint(int x) {
		//int x = 500;
		System.out.println("�Ű������� �ְ��ȯ���� ���� �޼ҵ��� �Ű������� : " + x);
	}
	public int calcNum(int input) {
		return input+500;
	}
}
