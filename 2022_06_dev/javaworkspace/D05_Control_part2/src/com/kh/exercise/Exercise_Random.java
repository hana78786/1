package com.kh.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random {
	public void exercise1(){
		//동전 앞뒤 맞추기
		Random rd= new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("===== 동전 앞 뒤 맞추기 ======");
		System.out.println("숫자를 입력하세요 1.앞면 2.뒷면");
		int input = sc.nextInt();
		if(input==1 || input==2) {
		if(input== rd.nextInt(2)+1) {
			System.out.println("정답입니다!");
		}
		else {
			System.out.println("틀렸습니다");
		}
		
		}
		else {
			System.out.println("1,2만 입력하세요");
			}
		}
		
	}

}
