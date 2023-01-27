package test1;

import java.util.Scanner;

public class Test0125 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[sc.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}
		double max = arr[0];
		double min = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (max < arr[i]) {
				max = arr[i];
			}

			if (min > arr[i]) {
				min = arr[i];
			}

		}

		for (int i = 0; i < arr.length; i++) {
			int mincount = 0;

			if (mincount == 0 && min == arr[i]) {
				double a = (min/max)*100;
				mincount++;
			}

		}
		int sum =0;
		int avg=0;
		for(int i =0;i<arr.length;i++) {
			sum += arr[i];
		}
		avg = sum/arr.length;
		System.out.println(avg);
		
	}

}
