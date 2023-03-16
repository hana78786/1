package test1;

import java.util.Scanner;

public class Test316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long a = num/4;
		String b ="";
		for(int i=0; i<a;i++) {
			b+="long ";
		}
		System.out.println(b+" int");
		
	}

}
