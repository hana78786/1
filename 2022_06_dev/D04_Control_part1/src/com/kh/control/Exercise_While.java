package com.kh.control;

import java.util.Scanner;

public class Exercise_While {
	public void exercise1() {
		// while���� �̿��Ͽ� 1 ~ 100 ������ Ȧ���� ���� ����Ͻÿ�.
		int i = 0;
		int sum = 0;
		while (i <= 100) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);

	}

	public void exercise2() {
// while���� �̿��Ͽ� ������ �ϳ� �Է¹޾� �� ���� 1 ~ 9������ �� �϶���
// �� ���� �������� ����Ͻÿ�.
// ��, ������ ���� ������ "1 ~ 9 ������ ����� �Է��Ͽ��� �մϴ�"�� ����Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���");
		int a = sc.nextInt();
		int i = 1;
		while (i <= 9) {
			if (a >= 1 && a <= 9) {
				System.out.println(a + "x" + i + "=" + a * i);
			} else {
				System.out.println("1~9������ ����� �Է��ؾ� �մϴ�");
				i=10;
			}
			i++;
		}

	}

	public void exercise3() {
		// while���� �̿��Ͽ� -1�� �Էµ� ������ ������ �Է¹ް�
		// -1�� �ԷµǸ� �Է��� ���� ���� ����Ͻÿ�.
		// ���� �ϳ� �Է� : 3
		// ���� �ϳ� �Է� : 4
		// ���� �ϳ� �Է� : 7
		// ���� �ϳ� �Է� : -1
		// �Է��Ͻ� ���� ���� : 14
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int a = 0;
		while (a != -1) {
			sum+=a;
			System.out.println("���ڸ� �Է��ϼ���");
			a=sc.nextInt();
		}

		System.out.println("�Է��Ͻ� ���� ���� : " + sum);
	}

	public void exercise4() {
/*
 * while���� �̿��Ͽ� -1�� �ɶ����� ���� �������� �Է¹ް� ����� ����Ͻÿ�. ������ �Է��ϰ� �������� -1�� �Է��ϼ��� 10 20 3
 * -20 -10 -1 ������ ������ 5���̸� ����� 0.6�Դϴ�.
 * 
 * ������ �Է��ϰ� �������� -1�� �Է��ϼ��� -1 �Էµ� ���� �����ϴ�.
 */
		Scanner sc=new Scanner(System.in);
		int i=0;
		int a=0;
		double sum=0;
		double bsum=0;
		System.out.println("������ �Է��ϼ���  ���� -1");
		a=sc.nextInt();	
		while(a!=-1) {
			i++; //�Էµ� ���� ����
			sum+=a; //�Էµ� ���� ��
			a=sc.nextInt();	
			bsum=sum/(i); //��� ����				
		}
		if(i==0) {
			System.out.println("�Էµ� ���� �����ϴ�.");
		}
		else {
			
		
		System.out.println("������ ������"+(i));
		System.out.println(bsum);}
		
		
		
	}
}
