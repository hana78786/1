package com.kh.memeber.run;


import java.util.ArrayList;

import com.kh.memeber.controller.MemberController;
import com.kh.memeber.model.vo.Member;
import com.kh.memeber.view.MemberView;

public class Run {
	public static void main(String[] args) {
		MemberView view= new MemberView();
		ArrayList<Member> mList = null;
		MemberController Mcont = new MemberController();
		Member member = null;
		int result =0;
		
	done:	while (true) {
			int choice = view.showMainMenu();
			switch (choice) {
			case 0:
				System.out.println("프로그램을 종료합니다");
				break done;
			case 1://전체조회
			 mList = Mcont.allMember();
			 if(!mList.isEmpty()) {
			 view.printAllMem(mList);}
			 else {
				 view.showFail("조회");
			 }
				break;
			case 2://아이디
				String serchId = view.serchId();
				member = Mcont.serchId(serchId);
				if(member==null) {view.showFail("조회");}
				else {
				view.printIdMem(member);}
				
				break;
			case 3://이름
				break;
			case 4://등록
				member = view.setMember();
				result = Mcont.setMember(member);
				if (result>0) {
					view.showSuccess("가입");
				}else {
					view.showFail("가입");
				}
				
				break;
			case 5://변경
				break;
			case 6://삭제
				break;
			default:
				System.out.println("잘못입력하셨습니다");
				break;

			}
		}
	}

}
