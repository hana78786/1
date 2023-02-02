package test1;

import java.util.Scanner;

public class Test0125 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	String str = "";
	int score = 0;
	
	String[] arrStr = str.split("");
	for(int i=0; i<sc.nextInt();i++) {
		str = sc.next();
	}
	for(int i =0; i<arrStr.length;i++) {
		if(i==0) {
			if(arrStr[i] == "O");
			score = 1;
		}
	}
	System.out.println(str);
	
	
	}

}
