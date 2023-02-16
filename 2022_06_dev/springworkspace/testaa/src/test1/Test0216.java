package test1;

import java.util.Scanner;

public class Test0216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n = 0;
		while(n<1000) {
			String b = a+"";
			int[] c = new int[b.length()];
			n=n+a;
			for(int i=0; i<c.length; i++) {
				n+=c[i];
				System.out.println(n);
			}
		}
	}
	

}
