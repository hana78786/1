package com.kh.student;

import java.util.Scanner;

public class Student_Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ManageStudent mStu = new ManageStudent();
		종료 : while (true) {
			mStu.showMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				//성적입력
				mStu.incertInfomation();
				break;
			case 2:
				//성적 출력
				mStu.printResult();
				break;
			case 3:
				//종료
				System.out.println("종료합니다");
				break 종료;
			default:
				//입력오류
				System.out.println("잘못 입력 하셨습니다.");
				break;
			}

		}
	}

}
