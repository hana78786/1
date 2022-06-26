package Exam;

import java.util.Random;
import java.util.Scanner;

public class Operator1 {

	public Operator1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
//		int a = 10;
//		int b = 20;
//		int c = 30;
//		a++;
//		b = (--a) + b;
//		c = (a++) + (--b);
//		System.out.println(a+" "+b+" "+c+" ");
//		int x =99;
//		int y =33;
//		int z =0;
//		x--;
//		z = x-- + --y;
//		x = 99 + x++ + x;
//		y = y-- + y + ++y;
//System.out.println(x+" "+y+" "+z);
//		System.out.println(a >> 1);
//		int a=70;
//		int b= 55;
//		System.out.println(a==b || a++<100);
//		System.out.println(a<b && --b <55);
//		System.out.println(a!=b && b-- < a++);
//		System.out.println(a++ != b || b++ >=85);
//		System.out.println(a +" "+ b);

//		int a = 10;
//		int b =20;
//		int c = 30;
//		a+=20;
//		System.out.println(a+" "+b+" "+c+" ");
//		b*=3;
//		System.out.println(a+" "+b+" "+c+" ");
//		c/=4;
//		System.out.println(a+" "+b+" "+c+" ");
//		a%=b;
//		System.out.println(a+" "+b+" "+c+" ");
//		c-=a;
//				System.out.println(a+" "+b+" "+c+" ");
//				
//		for(int i=1;i <= 10;i++) {
//			if (i%3==0) {
//			break;}
//			System.out.println(i);
//			}	
		Scanner scan = new Scanner(System.in);
//		System.out.println("번호선택 1.가위 2.바위 3보");
//		int a = scan.nextInt();
//		Random randome = new Random();
//		int b = randome.nextInt(3) + 1;
//		String c = null;
//		if(b==1) {c="가위";}
//		if(b==2) {c="바위";}
//		if(b==3) {c="보";}
//		System.out.println("ai는"+c+"를 냈다!");
//		if(a==b) {System.out.println("당신은 비겼다!");}
//		if((a==1 && b==2)|| (a==2 && b==3) || (a==3 && b==1)) {
//			System.out.println("당신은 졌다!");
//		}
//		if((a==1 && b==3)|| (a==2 && b==1) || (a==3 && b==2)) {
//			System.out.println("당신은 이겼다!");
//		}
		
		String[] arr= {"사과", "배", "귤", "바나나", "오이"};
		String banana = "바나나";
		int i =0;
		while(arr[i]!=banana) {
		i++;
		}
		System.out.println(arr[i]);
		
		for(int j=0; j<arr.length;j++) {
			if(arr[j]==banana) {
				System.out.println(arr[j]);
//				break;
			}
		}
		
	}

}
