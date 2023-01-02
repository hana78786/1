package test1;

import java.util.Scanner;

public class Test0102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int money= 0;
		if(a==b&&b==c) {
			money = 10000+a*1000;
		}else if(a==b || b==c) {
			money = 1000 + b*100;
		}else if(a==c) {
			money = 1000 + c*100;
		}else {
			if(a>b && a>c) {
				money = a*100;
			}else if(b>c && b>a) {
				money= b*100;
			}else {
				money = c*100;
			}
		}
		System.out.println(money);
	}

}
