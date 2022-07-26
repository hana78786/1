package book.run;

import Main.run.Mainrun;
import book.view.BookView;

public class BookRun {
	public static void main(String[] args) {
		BookView bView = new BookView();

		끝: while (true) {
			int choice = bView.mainMenu();
			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
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
