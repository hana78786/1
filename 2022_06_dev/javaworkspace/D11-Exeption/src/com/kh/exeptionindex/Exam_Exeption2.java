package com.kh.exeptionindex;

public class Exam_Exeption2 {
	public static void main(String [] args) throws  ArrayIndexOutOfBoundsException {
		int [] arrs = new int[3];
		
//		try {
			for (int i =0; i<arrs.length;i++) {
				arrs[i]=i;
			}
			System.out.println(arrs[5]);
			
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("인덱스 범위가 넘어갔습니다.");
//			
//		}
		
	}

}
