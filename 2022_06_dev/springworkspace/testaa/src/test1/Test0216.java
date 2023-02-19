package test1;

import java.util.Scanner;

public class Test0216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n = 0;
		String b = String.valueOf(a);
		while(n<1000) {
			int[] c = new int[b.length()];
			for(int i=0;i<c.length;i++) {
				c[i]=Integer.parseInt(b.substring(i, i+1));
			}
			n=n+a;
			for(int i=0; i<c.length; i++) {
				n+=c[i];
				System.out.println(n);
			}
		}
	}
	

}
