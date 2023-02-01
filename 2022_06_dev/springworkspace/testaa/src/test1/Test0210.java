package test1;

import java.util.Scanner;

public class Test0210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();

		}
		double max = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (max < arr[i]) {
				max = arr[i];
			}

		}

		for (int i = 0; i < arr.length; i++) {
	
				arr[i] = (arr[i]/max)*100;
				
				
			}

		
		double sum =0;
		double avg=0;
		for(int i =0;i<arr.length;i++) {
			sum += arr[i];
		}
		avg = sum/arr.length;
		System.out.println(avg);
		
	}

}
