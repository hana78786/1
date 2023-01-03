package test1;

import java.util.Scanner;

public class Test0103 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<10;i++) {
		System.out.printf(n+" * %d = %d \n",i, n*i);
		}
	}

}
