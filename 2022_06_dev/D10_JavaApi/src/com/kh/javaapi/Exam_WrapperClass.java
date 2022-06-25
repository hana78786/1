package com.kh.javaapi;

public class Exam_WrapperClass {
	public static void main(String[] args) {
		// Wrapper Ŭ����
		// �⺻ �ڷ����� ��üȭ ����
		int num = 3; // 3�� ����
		Integer input = new Integer(3); // 3�� �ּҰ��� ����
		parseExample();
	}
	
	static void boxingExample() {
		
		Integer nInput = 100; // 100 -> new Interger(100);Auto-Boxing
		// ��ü�� ������ִ°�
		int iNum = nInput; // input.intValue() -> input; Auto-Unboixing
		////////////////////////////////////////////////////

		
	}
	
	static void wrapperExample() {
		Long lnum = new Long(22222222);
		Integer value = Integer.valueOf(33);
		Long lValue = Long.valueOf("22222");
	}
	
	static void parseExample() {
		String strNum = "220613";
		String strNum2 = "221118";
//		int result = strNum2 - StrNum;
		int result = Integer.parseInt(strNum2) - Integer.parseInt(strNum);
		System.out.println("��� : " + result);

		String strNum3 = "3.14";
		double result1 = Double.parseDouble(strNum3);
		System.out.println("��� : " + result1);

		//////////////////////////////////////////////////////////
	}
	
	static void dataParsing() {
		byte bValue = Byte.parseByte("1");
		short sValue = Short.parseShort("2");
		int iValue = Integer.parseInt("3");
		long lInput = Long.parseLong("4");
		
		float fValue=Float.parseFloat("0.1");
		double dValue = Double.parseDouble("0.2");
		
		boolean bInput=Boolean.parseBoolean("true");
		
		char cValue = "Java".charAt(0); // �߿�!!!!!!!!!!!!!!!!
	}
	static void parsingStringExample() { // String���� ������ֱ�!!!
		// 3 -> String
		String bStr =Byte.valueOf((byte)1).toString();
		String iStr = Integer.valueOf(3).toString();
		String sStr = Short.valueOf((short)2).toString();
		String lStr = Long.valueOf(4l).toString();
		
		String fStr = Float.valueOf(0.3f).toString();
		String cStr = Character.valueOf('a').toString();

		byte a = 1;
		String data = String.valueOf(a);
		String input = 1234 + "";

		
		
	}

}
