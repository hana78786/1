package test1;

import java.util.Scanner;

public class Test0119 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b[] = new int[a];
		for (int i = 0; i < a; i++) {
			b[i]=sc.nextInt();
		}
		int c = sc.nextInt();
		int count = 0;
		for(int i=0;i<a;i++) {
			if(b[i]==c) {
				count++;
			}
		}
		System.out.println(count);
	}

}
