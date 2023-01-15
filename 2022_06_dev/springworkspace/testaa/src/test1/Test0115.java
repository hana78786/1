package test1;

import java.util.Scanner;

public class Test0115 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		int a;
		int b;
		do {
			a = sc.nextInt();
			b = sc.nextInt();
			if (a != 0 && b != 0) {
				str += (a + b) + "\n";
			}
		} while (a != 0 && b != 0);
		System.out.println(str);
	}

}
