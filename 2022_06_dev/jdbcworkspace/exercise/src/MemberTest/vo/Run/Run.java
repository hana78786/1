package MemberTest.vo.Run;

import java.util.ArrayList;

import MemberTest.Controller.Controller;
import MemberTest.Member.Member;
import MemberTest.View.View;

public class Run {
	public static void main(String[] args) {
		View view = new View();
		끝: while (true) {
			int choice = view.Menu();
			Controller cont = new Controller();
			ArrayList<Member> list = new ArrayList<Member>();
			
			switch (choice) {
			case 1: //전체
				list = cont.AllList();
				view.allList(list);
				break;
			case 2: //아이디
				String id = view.serchId();
				Member member = cont.idList(id);
				if(member == null) {
					view.fail("아이디 검색");
				}else {
					view.oneView(member);
				}
				break;
			case 3: //이름
				String name = view.serchName();
				list = cont.nameList(name);
				if(list.isEmpty()) {
					view.fail("이름 검색");
				}else {
					view.allList(list);;
				}
				break;
			case 4://등록
				member = view.setMember();
				int result = cont.insertMemeber(member);
				if(result == 0){
					view.fail("등록");
				}else {
					view.suceess("등록");
				}
				
				break;
			case 5://변경
				id = view.serchId();
				int count = cont.checkId(id);
				if(count==0) {					
					view.fail("아이디 검색");
				}else {
				member=	view.modifyMember();
				member.setMemberId(id);
				result = cont.updateMember(member);
					
				if(result == 0){
					view.fail("변경");
				}else {
					view.suceess("변경");
				}
				}
				
				
				break;
			case 6://삭제
				id = view.serchId();
				count = cont.checkId(id);
				if(count==0) {					
					view.fail("아이디 검색");}
				else {
					result = cont.delMember(id);
							if(result == 0){
								view.fail("삭제");
							}else {
								view.suceess("삭제");
							}	
				}
				
				break;
			case 0://종료
				System.out.println("종료합니다");
				break 끝;
			default:
				System.out.println("입력오류");
				break;
			}
		}
	}
}
