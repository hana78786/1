package test1;

import java.util.Scanner;

public class Test0203 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<sc.nextInt();i++) {
			String str = sc.next();
			String[] strArr = str.split("");
			int num = 0;
			int count = 0;
			for(int j=0;j<strArr.length;j++) {
				if(strArr[j].equals("O")) {
					count++;
					num=num+count;
				}
				System.out.println(num);
			}
		}
		
	}

}
