package test1;

import java.util.Scanner;

public class Test0203 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i=0;i<a;i++) {
			String str = sc.next();
			String[] strArr = str.split("");
			int num = 0;
			int count = 0;
			for(int j=0;j<strArr.length;j++) {
				if(strArr[j].equals("O")) {
					count++;
					num=num+count;
				}else {
					count=0;
				}
				
			}
			System.out.println(num);
		}
		
	}

}
