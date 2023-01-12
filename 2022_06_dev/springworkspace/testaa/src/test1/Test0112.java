package test1;

import java.util.Scanner;

public class Test0112 {

	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
         String star = "*";
      for(int i =0; i<num; i++){
          for(int j=0; j<i+1;j++){
          System.out.println(star);
      }
          System.out.println("");
  }
}

}
