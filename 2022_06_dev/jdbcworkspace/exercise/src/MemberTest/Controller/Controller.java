package MemberTest.Controller;

import java.util.ArrayList;

import MemberTest.DAO.DAO;
import MemberTest.Member.Member;

public class Controller {
	DAO dao = null;
	ArrayList<Member> list;

	public ArrayList<Member> AllList() {
		dao = new DAO();
		list = dao.allList();
		return list;
	}

	public Member idList(String id) {
		dao = new DAO();
		Member member = dao.idList(id);
		return member;
	}

	public ArrayList<Member> nameList(String name) {
		dao = new DAO();
		list = new ArrayList<Member>();
		list = dao.nameList(name);
		return list;
	}

	public int insertMemeber(Member member) {
		int result = 0;
		dao = new DAO();
		result = dao.insertMember(member);
		
		return result;
	}

	public int checkId(String id) {
		int count= 0;
		dao = new DAO();
		count = dao.checkId(id);
		return count;
	}

	public int updateMember(Member member) {
		dao = new DAO();
		int result = dao.updateMember(member);
		
		return result;
	}

	public int delMember(String id) {
		dao = new DAO();
		int result = dao.delMember(id);
		return result;
	}

}
