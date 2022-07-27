package Member.view;

import java.util.Scanner;

public class MemberView {
	
	public int mainMenu() {
		System.out.println("=-=-=-=-=-회원관리-=-=-=-=-=-");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 이름으로 조회");
		System.out.println("3. 회원 아이디로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("7. 메인 메뉴로 이동");
		System.out.print("선택 : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		return choice;
	}
	
	
	
}
