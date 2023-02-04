package test1;

import java.util.Scanner;

public class Test0204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i =0;i<num;i++) {
			int x = sc.nextInt();
			int[] score = new int[x];
			int avg=0;
			for(int j=0;j<x;j++) {
				score[j] = sc.nextInt();
				avg += score[j];				
			}
			avg = avg/x;
			int count=	0;
			for(int j=0;j<x;j++) {
				if(score[j]>avg) {
					count++;
				}
				
			}
			double per = (double)count/(double)x;
			System.out.println((float)per*100);
		}
	}

}
