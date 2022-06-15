package com.kh.exscanner;

import java.util.Scanner;

public class TestScanner3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		String name = sc.next();
		System.out.println("태어난 월을 입력해주세요");
		int birth = sc.nextInt();
		System.out.println("키를 입력해주세요");
		double tall = sc.nextDouble();
		System.out.println("성별을 입력해주세요 남/녀 ");
		char gen = sc.next().charAt(0);
		System.out.println("주소를 입력해주세요 (00시 00구)");
		sc.nextLine(); //엔터를 공백값으로 입력받기때문에 엔터를 입력받아줄 코드를 넣어야 한다
		String Adre = sc.next();

		System.out.println("이름은 " + name + "입니다.");
		System.out.println(birth + "에 태어났습니다.");
		System.out.println("키는 " + tall + "입니다");
		System.out.println("성별은 " + gen + " 입니다");
		System.out.println("주소는" + Adre + "입니다");


	}
}
