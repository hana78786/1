package test1;

import java.util.Scanner;

public class Test0116 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str ="";
		int a;
		int b;
		
		while(sc.hasNextInt()) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			str+= (a+b)+"\n";
			
		}
		System.out.print(str);
	}

}
