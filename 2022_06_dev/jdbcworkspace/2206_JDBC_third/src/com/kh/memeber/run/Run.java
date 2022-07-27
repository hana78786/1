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
				
				String serchName = view.serchName();
				mList = Mcont.serchName(serchName);
				if(mList.isEmpty()) {view.showFail("조회");}
				else {
					 view.printAllMem(mList);}
				
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
				serchId = view.serchId();
				result = Mcont.checkId(serchId);
				if(result>0) {
					String serchPwd= view.serchPwd();
					result = Mcont.serchPwd(serchPwd, serchId);
					if(result==0) {
						view.showFail("비밀번호 확인");
					}else {
						view.showSuccess("비밀번호 확인");
						member = view.modifyMem();
						result = Mcont.modifyMem(serchId, member);
						if (result==0) {view.showFail("정보변경");}
						else{view.showSuccess("정보변경");}												
						
					}
							
					
				}else {
					view.showFail("검색");
				}
				
				
				
				
				break;
			case 6://삭제
				serchId = view.serchId();
				result = Mcont.delMem(serchId);
				if(result==0) {
					view.showFail("탈퇴");
				}else {
					view.showSuccess("탈퇴");
				}
				
				
				
				
				break;
			default:
				System.out.println("잘못입력하셨습니다");
				break;

			}
		}
	}

}
