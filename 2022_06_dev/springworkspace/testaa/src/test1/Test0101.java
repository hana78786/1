package test1;

import java.util.Scanner;

public class Test0101 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int cook = sc.nextInt();
		
		min = min+cook;
		if(min>=60) {
			hour = (min/60)+hour;
			if(min%60==0) {
				min=0;
			}else {
				min= min%60;
			}
		}
		if(hour==24) {
			hour=0;
		}else if(hour>24){
			hour = hour-24;
			
		}
		
		System.out.println(hour+" "+min);
	}
}
