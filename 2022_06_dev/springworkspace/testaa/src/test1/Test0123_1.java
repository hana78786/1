package test1;

import java.util.Scanner;

public class Test0123_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[28];
		int[] b = new int[30];
		int c = 0;
		int d = 0;
		int[] e = new int[2];
		for (int i = 0; i < 28; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < 30; i++) {
			b[i] = i + 1;
			int count = 0;
			for (int j = 0; j < 28; j++) {
				if (b[i] == a[j]) {
					count++;
				}
			}
			if (count == 0) {
				if (c == 0) {
					c = b[i];
					count = 0;
				} else {
					d = b[i];
					count = 0;
				}
			}

		}

		if (c > d) {
			System.out.println(d);
			System.out.println(c);
		} else {
			System.out.println(c);
			System.out.println(d);

		}

	}
}
