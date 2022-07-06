package MemberControl.copy;

import java.util.List;
import java.util.Scanner;

public class MemberView {
	Scanner scan = new Scanner(System.in);

	public int pirntMenu() {
		System.out.println("================");
		System.out.println("1. 회원정보 전체조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 변경");
		System.out.println("6. 회원탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print(">>");
		int choice = scan.nextInt();
		return choice;

	}

	public Member memberPlus() {
		// TODO Auto-generated method stub
		System.out.println("회원정보를 입력하세요");
		Member member = new Member();
		System.out.print("아이디 :");
		member.setId(scan.next());
		System.out.print("이름 :");
		member.setName(scan.next());
		System.out.print("나이 :");
		member.setAge(scan.nextInt());

		return member;

	}

	public void printAllMember(List<Member> mList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mList.size(); i++) {
			Member member = mList.get(i);
			System.out.println("아이디 : "+member.getId());
			System.out.println("이름 : "+member.getName());
			System.out.println("나이 : "+member.getAge());
			System.out.println("=============");
		}

	}

	public String serchId() {
		// TODO Auto-generated method stub
		String id = scan.next();
		return id;
	}

	public void printSerchId(Member member) {
		// TODO Auto-generated method stub
		System.out.println("아이디 "+member.getId());
		System.out.println("이름 "+member.getName());
		System.out.println("나이 "+member.getAge());
		
		
	}

	public String serchName() {
		String name = scan.next();
		return name;
	}

	public void chageMemberInfo(Member member) {
		// TODO Auto-generated method stub
		System.out.println("정보를 다시 입력하세요");
		System.out.print("이름 :");
		member.setName(scan.next());
		System.out.print("나이 : ");
		member.setAge(scan.nextInt());
		System.out.println("정보 변경이 완료되었습니다.");
		
	}


}
