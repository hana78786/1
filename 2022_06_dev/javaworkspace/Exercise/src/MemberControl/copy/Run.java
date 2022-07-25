package MemberControl.copy;

import java.util.InputMismatchException;
import java.util.List;

public class Run {
	public static void main(String[] args) {

		MemberView mv = new MemberView();
		Control cont = new Control();

//		System.out.println("1. 회원정보 전체조회");
//		System.out.println("2. 회원 아이디로 조회");
//		System.out.println("3. 회원 이름으로 조회");
//		System.out.println("4. 회원 가입");
//		System.out.println("5. 회원 정보 변경");
//		System.out.println("6. 회원탈퇴");
//		System.out.println("0. 프로그램 종료");

		exit: while (true) {
			int choice = mv.pirntMenu();
			switch (choice) {
			case 1:
				System.out.println("회원전체조회");
				List<Member> mList = cont.allMember();
				mv.printAllMember(mList);
				break;
			case 2:
				System.out.println("아이디를 입력하세요");
				// 아이디값을 입력받는다
				String id = mv.serchId();
				// 아이디값을 for문으로 검색하고 아이디가 있는 인덱스 값을 찾는다
				int index = cont.serchIdIndex(id);
				if (index == -1) {
					System.out.println("검색실패");
					break;
				}
				// 그 인덱스 값을 받아 member를 출력한다
				Member member = cont.suchIdPrint(index);
				mv.printSerchId(member);

				break;
			case 3:
				System.out.println("이름을 입력하세요");
				String name = mv.serchName();
				index = cont.serchNameIndex(name);
				if (index == -1) {
					System.out.println("검색실패");
					break;
				}
				// 그 인덱스 값을 받아 member를 출력한다
				member = cont.suchIdPrint(index);
				mv.printSerchId(member);
				break;
			case 4:
				member = mv.memberPlus();
				cont.addlist(member);
				break;
			case 5:
				System.out.println("정보를 변경합니다");
				System.out.println("아이디를 입력하세요");
				
				id = mv.serchId();
				// 아이디값을 for문으로 검색하고 아이디가 있는 인덱스 값을 찾는다
				index = cont.serchIdIndex(id);
				if (index == -1) {
					System.out.println("검색실패");
					break;
				}
				// 그 인덱스 값을 받아 member를 출력한다
				member = cont.suchIdPrint(index);
				mv.chageMemberInfo(member);
				
				
				break;
			case 6:
				System.out.println("탈퇴메뉴입니다");
				System.out.println("탈퇴할 아이디를 입력하세요");
				
				id = mv.serchId();
				// 아이디값을 for문으로 검색하고 아이디가 있는 인덱스 값을 찾는다
				index = cont.serchIdIndex(id);
				if (index == -1) {
					System.out.println("검색실패");
					break;
				}
				cont.remove(index);
				
				
				break;
			case 0:
				break exit;
			default:
				break;
			}
		}

	}

}
