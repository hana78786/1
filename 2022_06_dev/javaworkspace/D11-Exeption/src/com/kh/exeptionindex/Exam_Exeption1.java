package com.kh.exeptionindex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam_Exeption1 {
	public static void main(String[] args) {
		// InputMismatchExeption
		// ArithmeticExeption
		// 정수 2개를 입력받아서 나눗셈연산수행
		// 0으로 나눌때 발생하는 예외처리
		// 정수입력받을때 발생하는 예외처리
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("첫번째 숫자 입력 : ");
				int num1 = sc.nextInt();
				System.out.println("두번째 숫자 입력 : ");
				int num2 = sc.nextInt();
				int result = num1/num2;
				System.out.println(num1+"을 "+ num2+"로 나눈 몫은 "+result);


			} catch (InputMismatchException e) {
				System.out.println("문자열은 입력할수 없습니다");
				sc.next();
				continue;
			}
			catch(ArithmeticException ex) {
				//java.lang.ArithmeticException lang패키지에 있는것들은 자동 import된다.
				System.out.println("0으로 나눌수 없습니다 "+ ex.getMessage());
				
			}finally {
			System.out.println("finally 늘 실행되는 코드");	
			}
		}

	}
}
