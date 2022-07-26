package Main.run;

import Main.view.Mainview;
import book.run.BookRun;

public class Mainrun {
	public static void main(String[] args) {
		Mainview view = new Mainview();

		int choice =0;

		끝: while (true) {
			choice = view.Main();
			switch (choice) {
			case 0:
				System.out.println("프로그램을 종료합니다");
				break 끝;
			case 1://책관리
				BookRun bRun = new BookRun();
				bRun.main(args);
				break 끝;
			case 2://회원관리
				break;
			case 3://대여관리
				break;
			default:
				System.out.println("입력오류");
				break;

			}

		}
	}

}
