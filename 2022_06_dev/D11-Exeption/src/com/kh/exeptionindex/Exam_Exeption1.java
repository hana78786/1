package com.kh.exeptionindex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam_Exeption1 {
	public static void main(String[] args) {
		// InputMismatchExeption
		// ArithmeticExeption
		// ���� 2���� �Է¹޾Ƽ� �������������
		// 0���� ������ �߻��ϴ� ����ó��
		// �����Է¹����� �߻��ϴ� ����ó��
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("ù��° ���� �Է� : ");
				int num1 = sc.nextInt();
				System.out.println("�ι�° ���� �Է� : ");
				int num2 = sc.nextInt();
				int result = num1/num2;
				System.out.println(num1+"�� "+ num2+"�� ���� ���� "+result);


			} catch (InputMismatchException e) {
				System.out.println("���ڿ��� �Է��Ҽ� �����ϴ�");
				sc.next();
				continue;
			}
			catch(ArithmeticException ex) {
				//java.lang.ArithmeticException lang��Ű���� �ִ°͵��� �ڵ� import�ȴ�.
				System.out.println("0���� ������ �����ϴ� "+ ex.getMessage());
				
			}finally {
			System.out.println("finally �� ����Ǵ� �ڵ�");	
			}
		}

	}
}
