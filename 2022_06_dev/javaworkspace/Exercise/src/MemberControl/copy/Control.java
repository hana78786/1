package MemberControl.copy;

import java.util.ArrayList;
import java.util.List;

public class Control {
	List<Member>mList;
	
	public Control() {
		mList = new ArrayList<Member>();
	}

	public void addlist(Member member) {
		// TODO Auto-generated method stub
		mList.add(member);
	}
	
	public List<Member> allMember() {
		return mList;
	}

	public int serchIdIndex(String id) {
		// TODO Auto-generated method stub
		//입력받은 아이디 값을 mList의 값과 비교 검색한다.
		for(int i =0; i<mList.size(); i++) {
			Member member = mList.get(i);
			if(member.getId().equals(id)) {
				return i;
			}
			
		}
		return -1;
	}

	public Member suchIdPrint(int index) {
		// TODO Auto-generated method stub
		Member member = mList.get(index);
		return member;
		
	}

	public int serchNameIndex(String name) {
		// TODO Auto-generated method stub
		for(int i =0; i<mList.size(); i++) {
			Member member = mList.get(i);
			if(member.getName().equals(name)) {
				return i;
			}
			
		}
		return -1;
	}

	public void remove(int index) {
		// TODO Auto-generated method stub
		mList.remove(index);
		
		
	}
	
	
	
}
