package com.kh.exeptionindex;

public class Exam_Exeption3 {
	public static void main(String[] args) {
		// NumberFomatExeption, 형변환 (문자 -> 숫자)
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
				System.out.println("숫자로 변환된 값은 : " + pNum);
			}
		} catch (NumberFormatException e) {
			System.out.println(strNumber[i] + "는 정수로 변환할 수 없습니다.");
		}
	}

}
