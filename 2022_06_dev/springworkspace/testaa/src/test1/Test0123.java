package test1;

import java.util.Scanner;

public class Test0123 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			int a = sc.nextInt();
			arr[i] = a;
		}
		int max = arr[0];
		int num = 1;
		for (int i = 0; i < 8; i++) {
			if (max < arr[i]) {
				max = arr[i];
				num = i + 1;
			}

		}
		System.out.println(max);
		System.out.println(num);
	}

}
