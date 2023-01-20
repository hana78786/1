package test1;

import java.util.Scanner;

public class Test0120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 0;
		String c ="";
		for (int i = 0; i < a; i++) {
			int d = sc.nextInt();
			if (d < b) {
				c += d+" ";
			
			}
		}
		
		System.out.println(c);
		
		
	
	
	}
}
