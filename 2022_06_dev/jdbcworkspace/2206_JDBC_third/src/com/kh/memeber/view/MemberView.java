package com.kh.memeber.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.memeber.model.vo.Member;

public class MemberView {
	
	public int showMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== 학생 관리 프로그램 ===========");
		System.out.println("1. 회원정보 전체 조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 정보 등록");
		System.out.println("5. 회원 정보 변경");
		System.out.println("6. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("번호선택 : ");
		
		return sc.nextInt();
	}

	public void printAllMem(ArrayList<Member> mList) {
		System.out.println("=-=-=전체 멤버 출력=-=-=-");
		for(Member mem1 : mList) {
		
			System.out.println("아이디 : "+mem1.getMemberId());
			System.out.println("비밀번호 : "+mem1.getMemberPwd());
			System.out.println("이름 : "+mem1.getMemberName());
			System.out.println("주소 : "+mem1.getAddress());
			System.out.println("이메일 : "+mem1.getEmail());
			System.out.println("전화 : "+mem1.getPhone());
			System.out.println("취미 : "+mem1.getHobby());
			System.out.println("나이 : "+mem1.getAge());
			System.out.println("성별 : "+mem1.getGender());
			System.out.println("가입날짜 : "+mem1.getEnRollDate());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
		}
		
	}

	public Member setMember() {
		Scanner sc = new Scanner(System.in);
		Member member = new Member();
		System.out.println("=-=-회원 정보 입력=-=-");
		System.out.print("아이디 : ");
		member.setMemberId(sc.next());
		System.out.print("비밀번호 : ");
		member.setMemberPwd(sc.next());
		System.out.print("이름 : ");
		member.setMemberName(sc.next());
		System.out.print("이메일 : ");
		member.setEmail(sc.next());
		System.out.print("전화 : ");
		member.setPhone(sc.next());
		System.out.print("주소 : ");
		sc.nextLine();
		member.setAddress(sc.nextLine());
		System.out.print("취미 : ");
		member.setHobby(sc.next());
		System.out.print("성별 (M,F만가능): ");
		member.setGender(sc.next().charAt(0));
		System.out.print("나이 : ");
		member.setAge(sc.nextInt());
		return member;
	}

	public void showFail(String string) {
		System.out.println("[서비스 결과] : "+ string+ "실패");
		
	}

	public void showSuccess(String string) {
		System.out.println("[서비스 결과] : "+string +"성공");
		
	}

	public String serchId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 아이디 : ");
		String serchId = sc.next();
		return serchId;
	}

	public void printIdMem(Member member) {
		
		System.out.println("아이디 : "+member.getMemberId());
		System.out.println("비밀번호 : "+member.getMemberPwd());
		System.out.println("이름 : "+member.getMemberName());
		System.out.println("주소 : "+member.getAddress());
		System.out.println("이메일 : "+member.getEmail());
		System.out.println("전화 : "+member.getPhone());
		System.out.println("취미 : "+member.getHobby());
		System.out.println("나이 : "+member.getAge());
		System.out.println("성별 : "+member.getGender());
		System.out.println("가입날짜 : "+member.getEnRollDate());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
	}

	public String serchName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름 : ");
		String serchName = sc.next();
		return serchName;
		
	}

	public String serchPwd() {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 : ");
		String serchPwd = sc.next();
		return serchPwd;
	}

	public Member modifyMem() {
		Member member = new Member();
		Scanner sc = new Scanner(System.in);
		System.out.println("=-=-회원 정보 입력=-=-");
		System.out.print("비밀번호 : ");
		member.setMemberPwd(sc.next());
		System.out.print("이름 : ");
		member.setMemberName(sc.next());
		System.out.print("이메일 : ");
		member.setEmail(sc.next());
		System.out.print("전화 : ");
		member.setPhone(sc.next());
		System.out.print("주소 : ");
		sc.nextLine();
		member.setAddress(sc.nextLine());
		System.out.print("취미 : ");
		member.setHobby(sc.next());

		
		
		
		return member;
	}

}
