package com.kh.exscanner;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��Ʈ���� �Է��ϼ���! >");
		int input1 = sc.nextInt();
		
		System.out.print("�ι�° ��Ʈ���� �Է����ּ���  >");
		int input2 = sc.nextInt();
		System.out.println("input : " + input1);
		System.out.println("input2 : "+input2);
	
		int result = input1+input2;
		
				System.out.println("�� ���� ���� : " +result+"�Դϴ�");
//				sc.close();
	}
	
}
