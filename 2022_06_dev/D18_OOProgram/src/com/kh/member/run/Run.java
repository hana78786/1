package com.kh.member.run;

import java.util.ArrayList;

import com.kh.member.controller.Controller;
import com.kh.member.model.vo.Member;
import com.kh.memeber.view.MemberView;

//실행클래스
public class Run {
	public static void main(String[] args) {
		MemberView mv = new MemberView();
		Controller controller = new Controller();
		Member member = null;

		done: while (true) {

			int choice = mv.mainMenu(); // 이 코드로 메인메뉴호출!

			switch (choice) {
			case 1:
				System.out.println("회원정보 조회");
				ArrayList<Member> mList = controller.printAllMember();
				mv.printAllMember(mList);
				break;
			case 2:
				System.out.println("회원 아이디로 조회");
				String memberId = mv.inputMemberId();
				int index = controller.findMeberId(memberId);
				if (index == -1) {
					mv.displayErro("회원 조회 실패");
				} else {
					member = controller.pirntOneById(index);
					mv.ShowopneMember(member);
				}
				break;
			case 3:
				System.out.println("회원 이름으로 조회");
				String memberName = mv.inputMemberName();
				index = controller.findMeberName(memberName);
				if (index == -1) {
					mv.displayErro("회원 조회 실패");
				} else {
					member = controller.pirntOneById(index);
					mv.ShowopneMember(member);
					
				}
				break;
			case 4:
				System.out.println("회원가입");
				member = mv.inputMember();
				controller.registerMember(member);
				break;
			case 5:
				System.out.println("회원 정보 변경");
				
				System.out.println("회원 아이디로 조회");
				memberId = mv.inputMemberId();
				index = controller.findMeberId(memberId);
				if (index == -1) {
					mv.displayErro("회원 조회 실패");
					break;
				} else {
					member = controller.pirntOneById(index);
					mv.ShowopneMember(member);
				}
				mv.changeMember(member);
				
				
				
				
				
				
				
				
				break;
			case 6:
				memberId = mv.inputMemberId();
				index = controller.findMeberId(memberId);
				if (index == -1) {
					mv.displayErro("회원 조회 실패");
				} else {
					controller.removeMember(index);
					mv.displaySuccess("회원 탈퇴 완료");
				}
				break;
			case 0:
				System.out.println("프로그램종료");
				break done;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}

	}

}
