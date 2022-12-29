package test1;

import java.util.Scanner;

public class Test1229 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point = sc.nextInt();
		if (point<=100 && point>=90) {
			System.out.println("A");
		}else if(point<=89 && point>=80) {
			System.out.println("B");
		}
		else if(point<=79 && point>=70) {
			System.out.println("C");
		}
		else if(point<=69 && point>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
	}
			
		

}
