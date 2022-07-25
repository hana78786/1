package com.kh.student;

import java.util.Scanner;

public class StudentRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentInfor sI = new StudentInfor();
		exit: while (true) {
			// 메뉴출력
			sI.printmenu();
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: //학생정보입력
				sI.StuInput();
				break;
			case 2: //학생정보출력
				sI.printInfo();
				break;
			case 3: // 종료
				System.out.println("종료합니다");
				break exit;
			default:
				System.out.println("잘못입력하셨습니다");
				break;
			}

		}
	}

}
