package MemberControl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Run {
	public static void main(String[] args) {

		MemberView mv = new MemberView();
		Member member = new Member();
		Control cont = new Control();

//		System.out.println("1. 회원정보 전체조회");
//		System.out.println("2. 회원 아이디로 조회");
//		System.out.println("3. 회원 이름으로 조회");
//		System.out.println("4. 회원 가입");
//		System.out.println("5. 회원 정보 변경");
//		System.out.println("6. 회원탈퇴");
//		System.out.println("0. 프로그램 종료");

	exit:	while (true) {
			try {
				int choice = mv.pirntMenu();
				switch (choice) {
				case 1:
					System.out.println("전체 조회");
					
					ArrayList<Member>mList=cont.allMember();
					mv.printall(mList);
					break;
				case 2:
					System.out.println("아이디로 조회");
					//그 인덱스값에 있는 id와 입력id가 같은지 비교한다
					//같은 id가 있는 인덱스 값을 가지고 와서 출력한다
					//없으면 실패메세지
					String id = mv.inputId();
					int index = cont.serchId(id);
					if(index==-1) {
						System.out.println("검색결과없음");
					break;
					}
					member = cont.serchPrintId(index);
					mv.printSerchId(member);
					break;
				case 3:
					String Name = mv.inputName();
					index = cont.serchName(Name);
					if(index==-1) {
						System.out.println("검색결과없음");
						break;
					}
					member = cont.serchPrintId(index);
					mv.printSerchId(member);
					
					
					break;
				case 4:
					System.out.println("회원가입");
					member = mv.memberPlus();
					cont.addList(member);
					break;
				case 5:
					id = mv.inputId();
					index = cont.serchId(id);
					if(index==-1) {
						System.out.println("검색결과없음");
					break;
					}
					member = cont.serchPrintId(index);
					mv.chageMemberInfo(member);
					
					break;
				case 6:
					id = mv.inputId();
					index = cont.serchId(id);
					if(index==-1) {
						System.out.println("검색결과없음");
					break;
					}
					System.out.println("아이디를 탈퇴합니다.");
					cont.remove(index);
					System.out.println("탈퇴가 완료되었습니다.");
					break;
				case 0:
					break exit;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("입력오류");
				break;
			}
		}

	}

}
