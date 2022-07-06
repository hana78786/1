package com.kh.memeber.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.model.vo.Member;

//출력담당클래스
public class MemberView {
	Scanner scan = new Scanner(System.in);
	public int mainMenu() {

		System.out.println("======== 회원관리 프로그램 =========");
		System.out.println("1. 회원정보 전체조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 변경");
		System.out.println("6. 회원탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("번호 선택 :");
		int choice = scan.nextInt();
		return choice;

	}

	public Member inputMember() {
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		System.out.println("아이디 : ");
		member.setMemberId(scan.next());
		System.out.println("비밀번호 : ");
		member.setMemberPwd(scan.next());
		System.out.println("이름 : ");
		member.setMemberName(scan.next());
		System.out.println("나이 : ");
		member.setMemberAge(scan.nextInt());
		System.out.println("성별 : ");
		member.setMemberGender(scan.next());
		System.out.println("이메일 : ");
		member.setMemberEmail(scan.next());
		System.out.println("전화번호 : ");
		member.setMemberPhone(scan.next());
		System.out.println("주소 : ");
		scan.nextLine();
		member.setMemberAddress(scan.nextLine());
		System.out.println("취미 : ");
		member.setMemberHobby(scan.next());

		return member;
	}
	
	
	
	
	public void printAllMember(List<Member>mlist) {
		System.out.println("===== 전체 회원 정보 조회 결과 =====");
		for(int i = 0 ; i<mlist.size();i++) {
			Member m1 = mlist.get(i);
			System.out.println("회원 아이디 : "+ m1.getMemberId());
			System.out.println("회원 이름 : "+ m1.getMemberName());
			System.out.println("회원 나이 : "+ m1.getMemberAge());
			System.out.println("==============================");
		
		}
	}

	
	public String inputMemberId() {
		System.out.print("검색 아이디 입력 :");
		return scan.next();
	}
	public String inputMemberName() {
		System.out.print("검색 이름 입력 :");
		return scan.next();
	}
	
	public void displaySuccess(String message) {
		System.out.println("[서비스 성공]"+message);
	}
	public void displayErro(String message) {
		System.out.println("[서비스 실패]"+message);
	}
	
	public void ShowopneMember(Member member) {
			System.out.println("회원 아이디 : "+ member.getMemberId());
			System.out.println("회원 이름 : "+ member.getMemberName());
			System.out.println("회원 나이 : "+ member.getMemberAge());
		
		
		
	}
	
	public Member changeMember(Member member) {
		
		System.out.println("아이디 : ");
		member.setMemberId(scan.next());
		System.out.println("비밀번호 : ");
		member.setMemberPwd(scan.next());
		System.out.println("이름 : ");
		member.setMemberName(scan.next());
		System.out.println("나이 : ");
		member.setMemberAge(scan.nextInt());
		System.out.println("성별 : ");
		member.setMemberGender(scan.next());
		System.out.println("이메일 : ");
		member.setMemberEmail(scan.next());
		System.out.println("전화번호 : ");
		member.setMemberPhone(scan.next());
		System.out.println("주소 : ");
		scan.nextLine();
		member.setMemberAddress(scan.nextLine());
		System.out.println("취미 : ");
		member.setMemberHobby(scan.next());

		return member;
		
	}
}
