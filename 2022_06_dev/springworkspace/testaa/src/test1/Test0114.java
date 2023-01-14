package test1;

import java.util.Scanner;

public class Test0114 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i =1; i<=num; i++){
            for(int j=0;j<num-i;j++){
            System.out.print(" ");
            }
            for(int k=0;k<i;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
       
    }    
}
