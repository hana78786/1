package MemberControl;

import java.util.ArrayList;
import java.util.List;

public class Control {
	ArrayList<Member> mList;
	
	public Control() {
		mList = new ArrayList<Member>();
	}

	public void addList(Member member) {
		mList.add(member);
		
	}

	public ArrayList<Member> allMember() {
		return mList;
		
		
	}

	public int serchId(String id) {		
		// TODO Auto-generated method stub
		for(int i=0;i<mList.size();i++) {
			Member mem = mList.get(i);
		 if(mem.getId().equals(id)) {
			 return i;
		 }
	 }
		
		return -1;
	}

	public Member serchPrintId(int index) {
		// TODO Auto-generated method stub
		Member member = mList.get(index);
		return member;
		
	}

	public int serchName(String name) {
		for(int i=0;i<mList.size();i++) {
			Member mem = mList.get(i);
		 if(mem.getName().equals(name)) {
			 return i;
		 }
	 }
		
		return -1;
		
	}

	public void remove(int index) {
		mList.remove(index);
		
		
	}

	
	
	
}
