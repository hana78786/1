package com.kh.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random {
	public void exercise1(){
		//���� �յ� ���߱�
		Random rd= new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("===== ���� �� �� ���߱� ======");
		System.out.println("���ڸ� �Է��ϼ��� 1.�ո� 2.�޸�");
		int input = sc.nextInt();
		if(input==1 || input==2) {
		if(input== rd.nextInt(2)+1) {
			System.out.println("�����Դϴ�!");
		}
		else {
			System.out.println("Ʋ�Ƚ��ϴ�");
		}
		
		}
		else {
			System.out.println("1,2�� �Է��ϼ���");
			}
		}
		
	}

}
