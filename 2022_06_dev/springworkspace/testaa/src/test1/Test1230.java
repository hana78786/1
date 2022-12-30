package test1;

import java.util.Scanner;

public class Test1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        
        if(min-45<0){
        hour = hour - 1;
        min = min+60-45;
            if(hour<0){
                hour=23;
                
            }
        }
        System.out.println(hour+" "+min);
    }
}


