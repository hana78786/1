package arr_Exam;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Array {

	public void exercise1() {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.println((i + 1) + "번째 값 :" + arr[i]);

		}
	}

	public void exercise2() {
		String arr[] = { "딸기", "복숭아", "키위", "사과", "바나나" };
		String banana = new String("바나나");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(banana)) {
				System.out.println(arr[i]);
			}
		}
	}

	public void exercise3() {
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[5];
		System.out.println("정수를 5개 입력하세요 : ");
		for (int i = 0; i < 5; i++) { 
			arr[i] = sc.nextInt();
		}
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
				}					
			
//			int c = 0;
//			for (int j = 0; j < arr.length; j++) {
//				if (arr[i] > arr[j]) {
//					c++;
//				}
//				if (c == arr.length-1) {
//					System.out.println(arr[i]);
//					break;
				}
		System.out.println(max);
			}
		


	public void exercise4() {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int arr[] = new int[5];
		System.out.println("숫자 5개 입력");
		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		int avr=sum/arr.length;
		System.out.println(avr);
	}
	
	public void exercise5() {
		Scanner sc = new Scanner(System.in);;
		System.out.println("주민등록번호를 입력하세요 :");
		String mNum = "";
		mNum =sc.nextLine();
		char[] arr=new char [mNum.length()];
		for (int i=0; i<arr.length;i++) {
			arr[i]= mNum.charAt(i);
			}
		for(int i=0; i<arr.length; i++) {
			if(i>7) {
				System.out.print("*");
			}
			else {
				System.out.print(arr[i]);
			}
		}
			
			
		}
		public void exercise7() {
			Random rand=new Random();
			int rotto[]=new int[6];
			for(int i=0;i<rotto.length;i++) {
				rotto[i]=rand.nextInt(5);
					for(int j=0;j<i;j++) {
				if (rotto[i]==rotto[j]) {
					i--;	
					break;
				}
				}
			}
			
			for(int i=0;i<rotto.length;i++) {
				System.out.println(rotto[i]);
			}
		}
	}


