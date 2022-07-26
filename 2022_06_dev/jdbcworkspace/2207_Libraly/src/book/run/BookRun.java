package book.run;

import java.util.ArrayList;

import Main.run.Mainrun;
import book.controller.BookController;
import book.view.BookView;
import book.vo.Book;

public class BookRun {
	public static void main(String[] args) {
		BookView bView = new BookView();
		ArrayList<Book> bList = new ArrayList<Book>();
		BookController bCont = new BookController();
		

		끝: while (true) {
			int choice = bView.mainMenu();
			switch (choice) {
			case 1://책조회
				bList = bCont.allBook();
				bView.ShowAllBook(bList);
				
				break;
			case 2://코드로 조회
				break;
			case 3://추가하기
				break;
			case 4://삭제하기
				break;
			case 5:
				Mainrun mRun = new Mainrun();
				mRun.main(args);
				break 끝;
			default:
				System.out.println("입력오류");
				break;

			}

		}
	}

}
