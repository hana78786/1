package com.kh.random;

import java.util.Random;

public class Exam_random {
	public static void main(String[] args) {
		Random rand= new Random();
		for(int i =0 ; i<10;i++) {
		System.out.println(rand.nextInt(11));
		}
		rand.nextInt(10); //0부터 9까지의 범위
//		rand.nextInt(10) + 1 ; // 1부터 10까지의 범위
		System.out.println(rand.nextInt(16)+20); // 0~15 -> 20~35 범위가 된다!!
		
	}
}
