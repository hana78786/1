package Member.Run;

import java.util.ArrayList;

import Main.run.Mainrun;
import Member.Controller.MemberController;
import Member.view.MemberView;
import Member.vo.Member;

public class MemberRun {
	public static void main(String[] args) {
		MemberView mView = new MemberView();
		ArrayList<Member> mList = null;
		MemberController mCont = new MemberController();
		
		
		끝: while (true) {
			int choice = mView.mainMenu();
			switch (choice) {
			case 1://전체조회
				mList = mCont.allMember();
				break;
			case 2://이름으로 조회
				break;
			case 3://아이디로 조회
				break;
			case 4://회원가입
				break;
			case 5://정보수정
				break;
			case 6://회원탈퇴
				break;
			case 7://메인메뉴
				Mainrun Mrun = new Mainrun();
				Mrun.main(args);
				break 끝;
			default:
				System.out.println("잘못된 입력입니다.");
				break;

			}
		}
	}
}
