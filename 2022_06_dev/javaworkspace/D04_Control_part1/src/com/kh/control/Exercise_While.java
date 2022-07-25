package com.kh.control;

import java.util.Scanner;

public class Exercise_While {
	public void exercise1() {
		// while문을 이용하여 1 ~ 100 사이의 홀수의 합을 출력하시오.
		int i = 0;
		int sum = 0;
		while (i <= 100) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);

	}

	public void exercise2() {
// while문을 이용하여 정수를 하나 입력받아 그 수가 1 ~ 9사이의 수 일때만
// 그 수의 구구단을 출력하시오.
// 단, 조건이 맞지 않으면 "1 ~ 9 사이의 양수를 입력하여야 합니다"를 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		int i = 1;
		while (i <= 9) {
			if (a >= 1 && a <= 9) {
				System.out.println(a + "x" + i + "=" + a * i);
			} else {
				System.out.println("1~9사이의 양수를 입력해야 합니다");
				i=10;
			}
			i++;
		}

	}

	public void exercise3() {
		// while문을 이용하여 -1이 입력될 때까지 정수를 입력받고
		// -1이 입력되면 입력한 수의 합을 출력하시오.
		// 정수 하나 입력 : 3
		// 정수 하나 입력 : 4
		// 정수 하나 입력 : 7
		// 정수 하나 입력 : -1
		// 입력하신 수의 합은 : 14
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int a = 0;
		while (a != -1) {
			sum+=a;
			System.out.println("숫자를 입력하세요");
			a=sc.nextInt();
		}

		System.out.println("입력하신 수의 합은 : " + sum);
	}

	public void exercise4() {
/*
 * while문을 이용하여 -1이 될때까지 정수 여러개를 입력받고 평균을 출력하시오. 정수를 입력하고 마지막에 -1을 입력하세요 10 20 3
 * -20 -10 -1 정수의 개수는 5개이며 평균은 0.6입니다.
 * 
 * 정수를 입력하고 마지막에 -1을 입력하세요 -1 입력된 수가 없습니다.
 */
		Scanner sc=new Scanner(System.in);
		int i=0;
		int a=0;
		double sum=0;
		double bsum=0;
		System.out.println("정수를 입력하세요  종료 -1");
		a=sc.nextInt();	
		while(a!=-1) {
			i++; //입력된 수의 갯수
			sum+=a; //입력된 수의 합
			a=sc.nextInt();	
			bsum=sum/(i); //평균 공식				
		}
		if(i==0) {
			System.out.println("입력된 수가 없습니다.");
		}
		else {
			
		
		System.out.println("정수의 갯수는"+(i));
		System.out.println(bsum);}
		
		
		
	}
}
