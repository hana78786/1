package com.kh.yeze;

public class change_Type {
	public static void main(String[] args) {
		int intVal = 100;
		double doubleVal = intVal;
		System.out.println("intVal : " + intVal + ", doubleVal :" + doubleVal);

		char chVal = 'A';
		int uniCode = chVal;
		System.out.println("chVal " + chVal + ",uniCode : " + uniCode);

		long longVal = 100000000000000L;
		int intVal1 = (int) longVal; // 8��Ʈ Long->4��Ʈ int ���� Long���� 4��Ʈ�� �Ѿ�� �߷��� ��ȯ�� System.out.println(intVal1);
		System.out.println(intVal1);
		double dValue = 121000000001203.51521;
		int iValue = (int) dValue; // 8����Ʈ doulbe->4����Ʈint��
		System.out.println(iValue);
	}

}
