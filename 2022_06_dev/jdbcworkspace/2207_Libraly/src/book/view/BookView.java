package book.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.vo.Book;

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

	public void ShowAllBook(ArrayList<Book> bList) {
		for(Book book : bList) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("번호 : "+book.getBookNumber());
			System.out.println("책 이름 : "+book.getBookName());
			System.out.println("작가 : "+book.getBookWriter());
			System.out.println("가격 : "+book.getBookPrice());
			System.out.println("출판사 : "+book.getPublisher());
			System.out.println("분류 : "+book.getGenre());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		}
	}
	

}
