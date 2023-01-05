package test1;

import java.util.Scanner;

public class Test0105 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] buy = new int[n];
		int pay=0;
		
		for(int i =0; i<n;i++) {
			num[i] = sc.nextInt();
			buy[i]=sc.nextInt();
			pay += num[i]*buy[i];
		}

		if(pay==x) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
			
		}
		
	}

}
