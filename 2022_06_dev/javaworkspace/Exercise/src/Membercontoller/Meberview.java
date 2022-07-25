package Membercontoller;

import java.util.Scanner;

public class Meberview {
Scanner scan = new Scanner(System.in);
	
	public int mainMenu() {

		System.out.println("======== 회원관리 프로그램 =========");
		System.out.println("1. 회원정보 전체조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 변경");
		System.out.println("6. 회원탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("번호 선택 :");
		int choice = scan.nextInt();
		return choice;

	}
}
