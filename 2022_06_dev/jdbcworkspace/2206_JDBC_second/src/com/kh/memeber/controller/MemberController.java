package com.kh.memeber.controller;

import java.util.ArrayList;

import com.kh.memeber.model.dao.MemberDAO;
import com.kh.memeber.model.vo.Member;

public class MemberController {
	private MemberDAO mDao;
	public ArrayList<Member> allMember() {
		MemberDAO mDao = new MemberDAO();
		ArrayList<Member> mList = mDao.allMember();
		return mList;
	}

	public int setMember(Member member) {
		mDao = new MemberDAO();
		int result = mDao.setMemeber(member);

		return result;
	}

	public Member serchId(String serchId) {
	 mDao= new MemberDAO();
	 Member member= mDao.serchId(serchId);
		
		
		
		
		return  member ;
	}

	public ArrayList<Member> serchName(String serchName) {
		 mDao= new MemberDAO();
		ArrayList<Member> mList = mDao.serchName(serchName);
			
			
			return mList ;
	}

	public int delMem(String serchId) {
		mDao = new MemberDAO();
		int result = mDao.delMem(serchId);
		return result;
	}

	public int checkId(String serchId) {
		mDao = new MemberDAO();
		int result = mDao.checkId(serchId);
		return result;
	}

	public int modifyMem(String serchId, Member member) {
		mDao = new MemberDAO();
	int	result = mDao.modifyMem(serchId, member);
	return result;
		
	}

	public int serchPwd(String serchPwd, String serchId) {
		mDao = new MemberDAO();
		int	result = mDao.serchPwd(serchPwd, serchId);
		
		return result;
		
	}

}
