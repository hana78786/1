package java_ex;

import java.util.Scanner;

public class ex1 {

	       
	   
	    public static void main(String[] args) {
	    	ex1 e1=new ex1();
	    	Scanner scanner=new Scanner(System.in);
	    	int a=scanner.nextInt();
	    	int b=scanner.nextInt();
	    	long[] answer= new long[b];
	    	for(int i=0;i<b;i++) {
	    		answer[i]= a;
	    		a+=a;
	    		System.out.println(answer[i]);
	    	}
			

	    }
	}

