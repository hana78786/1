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
		System.out.println("������ �Է��ϼ���");
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
		String arr[] = { "���", "��", "��", "����", "������", "����" };
		String mikan = "��";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(mikan)) {
				System.out.println(arr[i] + "�� " + (i + 1) + "��° �迭");
				break;
			}
		}
	}

	public void practice5() {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("�˻��� ���ڸ� �Է��ϼ���(�ѱ��ڸ�����)");
		char ch = sc.nextLine().charAt(0);
		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == (ch)) {
				System.out.print(ch + "�� " + (i + 1) + "��° ");
				c++;
			}

		}
		System.out.println();
		System.out.println(ch + "�� ������ : " + c);

	}

	public void practice6() {
		String[] arr = { "��", "ȭ", "��", "��", "��", "��", "��" };
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ���(0~6) : ");
		int num = sc.nextInt();
		if (num < 0 || num > 6) {
			System.out.print("�߸� �Է��ϼ̽��ϴ�.");
		} else {
			System.out.println(arr[num] + "����");
		}

	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� :");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int a = 0;
		int sum = 0;
		for (int i = 0; i < num; i++) {
			System.out.printf("%d��° �ε����� ������ \n", i);
			a = sc.nextInt();
			arr[i] = a;
			sum += a;
		}
		for (int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("���� : " + sum);
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (num < 3 || num % 2 == 0) {
			System.out.println("(3�̻��Է�)���� :");
			num = sc.nextInt();
			if (num < 3 || num % 2 == 0) {
				System.out.println("�ٽ� �Է��ϼ���");
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
		System.out.println("===ġŲ�޴�===");
		System.out.println("1. �Ҵ�");
		System.out.println("2. �ݹ� ������");
		System.out.println("3. ����Ʈ ����");
		System.out.println("4. ���");
		System.out.println("5. ���� ���� ���");
		String arr[] = { "�Ҵ�", "���", "����Ʈ ����" };
		Scanner sc = new Scanner(System.in);
		System.out.print("ġŲ �̸��� �Է��ϼ��� :");
		String menu = sc.nextLine();
		boolean bedal = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(menu)) {
				System.out.println(menu + "��ް���");
				bedal = true;
				break;
			} else {
				bedal = false;
			}
		}
		if (bedal == false) {
			System.out.println(menu + "��޺Ұ�");
		}

	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹε�Ϲ�ȣ(-����)");
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
		System.out.print("���ڿ� : ");
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
		System.out.println("���ڰ���"+ arr.length);
	}

}
