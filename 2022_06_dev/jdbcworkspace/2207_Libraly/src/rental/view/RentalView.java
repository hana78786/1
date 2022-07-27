package rental.view;

import java.util.Scanner;

public class RentalView {

	public int RentalMenu() {
		System.out.println("1. 대여 관리 전체 조회\r\n" 
				+ "2. 회원 아이디로 대여 조회\r\n" 
				+ "3. 책 이름으로 대여 조회\r\n" 
				+ "4. 대여정보 추가\r\n"
				+ "5. 메인 메뉴로 이동");
		System.out.print("메뉴선택 : ");
		
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
