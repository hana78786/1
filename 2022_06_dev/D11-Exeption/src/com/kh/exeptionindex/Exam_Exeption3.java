package com.kh.exeptionindex;

public class Exam_Exeption3 {
	public static void main(String[] args) {
		// NumberFomatExeption, ����ȯ (���� -> ����)
		String numStr = "3";
		int num = Integer.parseInt(numStr);
		String dNumStr = "3.14";
//		double dNum = 0;
//		dNum = Double.parseDouble(dNumStr);
//			int parseNum = Integer.parseInt(dNumStr);
		String[] strNumber = { "1", "2", "13.1", "100" };
		int i =0;
		try {
			for (i = 0; i < strNumber.length; i++) {
				int pNum =Integer.parseInt(strNumber[i]);
				System.out.println("���ڷ� ��ȯ�� ���� : " + pNum);
			}
		} catch (NumberFormatException e) {
			System.out.println(strNumber[i] + "�� ������ ��ȯ�� �� �����ϴ�.");
		}
	}

}
