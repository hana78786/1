package test1;

import java.util.Scanner;

public class Test0117 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		int n = 9999;
		int a = 9999;
		while (a != num) {
			if (count == 0) {
				n = num / 10 + num % 10;
				a = (num % 10) * 10 + n%10;
			}else {
				n = a/10 + a%10;
				a = (a%10)*10+n%10;
			}

			count++;

		}
		System.out.println(count);
	}

}
