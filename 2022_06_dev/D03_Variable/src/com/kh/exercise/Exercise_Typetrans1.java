package com.kh.exercise;

import java.util.Scanner;

public class Exercise_Typetrans1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자 하나 입력해주세요 : ");
		int input=sc.nextInt();
		System.out.println("문자로 변환 : "+(char)input);
	}
}
