package MemberTest.View;

import java.util.ArrayList;
import java.util.Scanner;

import MemberTest.Member.Member;

public class View {
	
	public int Menu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 학생전체조회");
		System.out.println("2. 아이디조회");
		System.out.println("3. 이름조회");
		System.out.println("4. 정보등록");
		System.out.println("5. 정보변경");
		System.out.println("6. 정보삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
		int choice = sc.nextInt();
		return choice;
		
	}

	public void allList(ArrayList<Member> list) {
		for(Member member : list) {
			System.out.println("아이디 "+member.getMemberId());
			System.out.println("이름 "+member.getMemberName());
			System.out.println("비밀번호 "+member.getMemberPwd());
			System.out.println("나이 "+member.getAge());
			System.out.println("성별 "+member.getGender());
			System.out.println("이메일 "+member.getEmail());
			System.out.println("전화  "+member.getPhone());
			System.out.println("주소  "+member.getAddress());
			System.out.println("취미  "+member.getHobby());
			System.out.println("가입일  "+member.getEndrollDate());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		
	}

	public String serchId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		return sc.next();
	}

	public void fail(String string) {
		System.out.println(string+"실패");
		
	}

	public void oneView(Member member) {
		
		System.out.println("아이디 "+member.getMemberId());
		System.out.println("이름 "+member.getMemberName());
		System.out.println("비밀번호 "+member.getMemberPwd());
		System.out.println("나이 "+member.getAge());
		System.out.println("성별 "+member.getGender());
		System.out.println("이메일 "+member.getEmail());
		System.out.println("전화  "+member.getPhone());
		System.out.println("주소  "+member.getAddress());
		System.out.println("취미  "+member.getHobby());
		System.out.println("가입일  "+member.getEndrollDate());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
	}

	public String serchName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 : ");
		
		return sc.next();
	}

	public Member setMember() {
		Member member = new Member();
		Scanner sc =new Scanner(System.in);
		
		System.out.println("아이디 ");
		member.setMemberId(sc.next());
		System.out.println("이름 ");
		member.setMemberName(sc.next());
		System.out.println("비밀번호 ");
		member.setMemberPwd(sc.next());
		System.out.println("나이 ");
		member.setAge(sc.nextInt());
		System.out.println("성별 ");
		member.setGender(sc.next().charAt(0));
		System.out.println("이메일 ");
		member.setEmail(sc.next());
		System.out.println("전화  ");
		member.setPhone(sc.next());
		System.out.println("주소  ");
		sc.nextLine();
		member.setAddress(sc.nextLine());
		System.out.println("취미  ");
		member.setHobby(sc.next());

		return member;
	}

	public void suceess(String string) {
		System.out.println(string+"성공");
		
	}

	public Member modifyMember() {
		Member member = new Member();
		Scanner sc =new Scanner(System.in);

		System.out.println("이름 ");
		member.setMemberName(sc.next());
		System.out.println("비밀번호 ");
		member.setMemberPwd(sc.next());
		System.out.println("나이 ");
		member.setAge(sc.nextInt());
		System.out.println("이메일 ");
		member.setEmail(sc.next());
		System.out.println("전화  ");
		member.setPhone(sc.next());
		System.out.println("주소  ");
		sc.nextLine();
		member.setAddress(sc.nextLine());
		System.out.println("취미  ");
		member.setHobby(sc.next());

		return member;
	}

}
