package rental.run;

import Main.run.Mainrun;
import Main.view.Mainview;
import rental.view.RentalView;

public class RentalRun {
	public static void main(String[] args) {
		RentalView rView = new RentalView();

		끝: while (true) {
			int choice = rView.RentalMenu();
			switch (choice) {
			case 1://대여전체조회
				
		
				break;
			case 2://회원아이디로 대여조회
				break;
			case 3://책이름으로 조회
				break;
			case 4://대여정보추가
				break;
			case 5://메인메뉴로 이동
				Mainrun Run = new Mainrun();
				Run.main(args);
				
				break 끝;
			default:
				break;
			}
		}
	}
}
