package com.kh.control;

import java.util.Scanner;

public class Exa_Break1 {
	public static void main(String[] args) {
		// ���ڿ��� �Է¹޾� ���� ������ ����ϴ� ���α׷��ε�
		// "end"�� �ԷµǸ� �ݺ��� ������.
		// ���ѹݺ�
		// end�� �ԷµǸ� �����ϱ�
		// while�� ���ѹݺ��ϱ�! - while(true){}
		// for�� ���ѹݺ��ϱ� - for(���ǹ��Ⱦ�;;�Ⱦ�) �׷� ���ѹݺ��� (;;)������!
		while (true) {
			System.out.println("���ڿ��� �Է��ϼ���");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			// input�� end�϶� ����
			if (input.equals("end")){ //input=="end"  �̰� ������� ����! ���ڿ��� .equals("���ڿ�")�� ����!
				break;
			}
			System.out.println ("���ڿ��� ����" + input.length());
		}

	}
}
