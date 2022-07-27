package Member.Controller;

import java.util.ArrayList;

import Member.dao.MemberDAO;
import Member.vo.Member;

public class MemberController {
	ArrayList<Member> mList = null;
	MemberDAO mDao = new MemberDAO();
	

	public ArrayList<Member> allMember() {
		mList = new ArrayList<Member>();
		mList = mDao.allMember();
	
		return mList;
	}

}
