package test1;

import java.util.Scanner;

public class Test1228_1 {
	 public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        int a= sc.nextInt();
	        int b= sc.nextInt();
	        String strB=b+"";
	        String[] arrB=strB.split("");
	       System.out.println(Integer.parseInt(arrB[2])*a);
	       System.out.println(Integer.parseInt(arrB[1])*a);
	       System.out.println(Integer.parseInt(arrB[0])*a);
	       System.out.println(b*a);
	        
	        }

}
