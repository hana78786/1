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
		int intVal1 = (int) longVal; // 8비트 Long->4비트 int 실제 Long값이 4비트가 넘어가면 잘려서 변환됨 System.out.println(intVal1);
		System.out.println(intVal1);
		double dValue = 121000000001203.51521;
		int iValue = (int) dValue; // 8바이트 doulbe->4바이트int로
		System.out.println(iValue);
	}

}
