package com.kh.exercise;

import java.util.Random;
import java.util.Scanner;

public class arr_Exercise {
	public void practice1() {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void practice2() {
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length - 1 - i] = i + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();
		int arr[] = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public void practice4() {
		String arr[] = { "사과", "배", "귤", "포도", "복숭아", "참외" };
		String mikan = "귤";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(mikan)) {
				System.out.println(arr[i] + "은 " + (i + 1) + "번째 배열");
				break;
			}
		}
	}

	public void practice5() {
		System.out.println("문자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("검색할 문자를 입력하세요(한글자만가능)");
		char ch = sc.nextLine().charAt(0);
		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == (ch)) {
				System.out.print(ch + "는 " + (i + 1) + "번째 ");
				c++;
			}

		}
		System.out.println();
		System.out.println(ch + "의 갯수는 : " + c);

	}

	public void practice6() {
		String[] arr = { "월", "화", "수", "목", "금", "토", "일" };
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요(0~6) : ");
		int num = sc.nextInt();
		if (num < 0 || num > 6) {
			System.out.print("잘못 입력하셨습니다.");
		} else {
			System.out.println(arr[num] + "요일");
		}

	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 :");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int a = 0;
		int sum = 0;
		for (int i = 0; i < num; i++) {
			System.out.printf("%d번째 인덱스에 넣을값 \n", i);
			a = sc.nextInt();
			arr[i] = a;
			sum += a;
		}
		for (int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("총합 : " + sum);
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (num < 3 || num % 2 == 0) {
			System.out.println("(3이상입력)정수 :");
			num = sc.nextInt();
			if (num < 3 || num % 2 == 0) {
				System.out.println("다시 입력하세요");
			}
		}
		int center = num / 2 + 1;
		int arr[] = new int[num];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < center) {
				j++;
			} else if (i >= center) {
				j--;
			}
			arr[i] = j;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public void practice9() {
		System.out.println("===치킨메뉴===");
		System.out.println("1. 불닭");
		System.out.println("2. 반반 무마니");
		System.out.println("3. 스위트 간장");
		System.out.println("4. 양념");
		System.out.println("5. 순살 매콤 허니");
		String arr[] = { "불닭", "양념", "스위트 간장" };
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 :");
		String menu = sc.nextLine();
		boolean bedal = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(menu)) {
				System.out.println(menu + "배달가능");
				bedal = true;
				break;
			} else {
				bedal = false;
			}
		}
		if (bedal == false) {
			System.out.println(menu + "배달불가");
		}

	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함)");
		String num = sc.nextLine();
		char[] num_a = new char[num.length()];
		for (int i = 0; i < num_a.length; i++) {
			num_a[i] = num.charAt(i);
		}
		for (int i = 0; i < num_a.length; i++) {
			if (i >= 8) {
				System.out.print("*");
			} else {
				System.out.print(num_a[i]);
			}
		}
	}

	public void practice11() {
		Random rd = new Random();
		int arr[] = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(41) + 6;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		char a = 0;
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
			for (int j = 0; j < i; j++) {
				if(arr[i]==arr[j]) {
					a=arr[i];
				}
			}
			
			if(arr[i]==a) {}
			else if(i==0) {System.out.print(arr[0]);}
			else {
			System.out.print(" ,"+arr[i]);}
		}
		System.out.println();
		System.out.println("문자개수"+ arr.length);
	}

}
