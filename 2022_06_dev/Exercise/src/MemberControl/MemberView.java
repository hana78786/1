package MemberControl;

import java.util.List;
import java.util.Scanner;

public class MemberView {
Scanner scan = new Scanner(System.in);
	public int pirntMenu() {
		Scanner scan = new Scanner(System.in);

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
		Member mb = new Member();
		System.out.println("아이디");
		mb.setId(scan.next());
		System.out.println("이름");
		mb.setName(scan.next());
		System.out.println("나이");
		mb.setAge(scan.nextInt());
		
		return mb;
		
	}
	public void printall(List<Member> mList) {
		// TODO Auto-generated method stub
		for(int i =0;i<mList.size();i++) {
			Member mem = mList.get(i);
			System.out.println("이름 : "+mem.getName());
			System.out.println("id : "+mem.getId());
			System.out.println("나이 : "+mem.getAge());
			System.out.println("=====================");
		}
		
	}
	public String inputId() {
		System.out.println("검색할 아이디 입력");
		String Id = scan.next();
		return Id;
	}
	public void printSerchId(Member member) {
		// TODO Auto-generated method stub
		System.out.println("이름 : "+member.getName());
		System.out.println("id : "+member.getId());
		System.out.println("나이 : "+member.getAge());
		System.out.println("=====================");
		
		
	}
	public String inputName() {
		// TODO Auto-generated method stub
		System.out.println("검색할 이름 입력");
		String Name = scan.next();
		return Name;
		
	}
	public void chageMemberInfo(Member member) {
		System.out.println("입력한 아이디의 정보를 변경합니다");
		System.out.print("이름 : ");
		member.setName(scan.next());
		System.out.println("나이 : ");
		member.setAge(scan.nextInt());
		
	}
	
	
	
}
