package com.kh.motel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MotelMain {
	public static void main(String[] args) throws InputMismatchException {
		MotelMenu motelM = new MotelMenu();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		종료: while (true) {
			motelM.PrintMenu();

			try {
				System.out.print("선택  : ");
				choice = sc.nextInt();
				switch (choice) {
				case 1: // 체크인
					motelM.checkIn(sc);
					break;
				case 2: // 체크아웃
					motelM.checkOut(sc);
					break;
				case 3: // 룸체크
					motelM.roomCheck();
					break;
				case 4: // 종료
					System.out.println("종료합니다");
					break 종료;
				default : System.out.println("메뉴를 다시 확인해주세요");
				break;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다.");
				sc.next();
				continue;

			}
		}
	}

	

}
