package test1;

import java.util.Scanner;

public class Test316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextInt();
		String b ="";
		for(int i=0; i<num/4;i++) {
			b+="long ";
		}
		System.out.println(b+"int");
		
	}

}
