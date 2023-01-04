package test1;

import java.util.Scanner;

public class Test0104 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0; i<num;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = a+b;
		}
		
		for(int i=0;i<num;i++) {
			System.out.println(arr[i]);
		}
	}

}
