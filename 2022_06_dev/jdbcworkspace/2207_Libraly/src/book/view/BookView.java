package book.view;

import java.util.Scanner;

public class BookView {

	public int mainMenu() {
		System.out.println("=-=-=-=책관리=-=-=-=");
		System.out.println("1. 전채 책 조회");
		System.out.println("2. 책 코드로 조회");
		System.out.println("3. 책 추가하기");
		System.out.println("4. 책 삭제하기");
		System.out.println("5. 메인 메뉴로 이동");
		System.out.print("선택 : ");
		
		Scanner sc = new Scanner(System.in);
		
		
		return sc.nextInt();
	}
	

}
