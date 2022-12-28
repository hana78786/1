package test1;

import java.util.Scanner;

public class Test1228 {

	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int[] input = new int[6];
	        for(int i=0; i<input.length ;i++){
	            input[i]= sc.nextInt();
	        }
	        input[0]=1-input[0];
	        input[1]=1-input[1];
	        input[2]=2-input[2];
	        input[3]=2-input[3];
	        input[4]=2-input[4];
	        input[5]=8-input[5];
	  
	            System.out.print(input[0] + " " + input[1] + " "+input[2] + " "+input[3]+" "+input[4]+" "+input[5]);

	  
	     
	    }
	}

