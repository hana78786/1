package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Logical1 {
	public static void main(String[] args) {

		// �Է��� �������� 1 ~ 100 ������ �������� Ȯ���Ͻÿ�
		// ������ �ϳ� �Է����ּ��� : 33
		// 1���� 100������ �����ΰ�? : true
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է����ּ��� :");
		int a=sc.nextInt();
		

//		boolean a1;
		
		boolean a1=(a>1&&a<100) ? true:false;
//		if (a>1&&a<100) {
//			a1=true;
//		} 
//		else {
//			a1=false;
//		}
		 System.out.print("1���� 100������ �����ΰ�?"+a1);
		

	}

}
