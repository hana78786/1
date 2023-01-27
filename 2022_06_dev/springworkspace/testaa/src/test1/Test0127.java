package test1;

import java.util.HashSet;
import java.util.Scanner;

public class Test0127 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> list =new HashSet<Integer>(); 
		for (int i = 0; i < 10; i++) {
			list.add(sc.nextInt()%42);	

		}
		System.out.println(list.size());
		
		
	}

}
