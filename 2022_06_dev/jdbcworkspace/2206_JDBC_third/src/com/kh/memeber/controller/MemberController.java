package com.kh.memeber.controller;

import java.util.ArrayList;

import com.kh.memeber.model.dao.MemberDAO;
import com.kh.memeber.model.service.MemberService;
import com.kh.memeber.model.vo.Member;

public class MemberController {
	private MemberDAO mDao;
	private MemberService mService;
	
	
	public MemberController() {
		mService = new MemberService();
	}
	
	
	public ArrayList<Member> allMember() {
		MemberDAO mDao = new MemberDAO();
		ArrayList<Member> mList = mService.printAll();
		return mList;
	}
	


	public int setMember(Member member) {
		//mDao = new MemberDAO();
		int result = mService.resgisterMeber(member);

		return result;
	}
	
	

	public Member serchId(String serchId) {
	// mDao= new MemberDAO();
	 Member member= mService.serchId(serchId);
	
		return  member ;
	}
	
	

	public ArrayList<Member> serchName(String serchName) {
		// mDao= new MemberDAO();
		ArrayList<Member> mList = mService.serchName(serchName);
			
			
			return mList ;
	}

	public int delMem(String serchId) {
		//mDao = new MemberDAO();
		int result = mService.delMem(serchId);
		return result;
	}

	public int checkId(String serchId) {
		//mDao = new MemberDAO();
		int result = mService.checkId(serchId);
		return result;
	}

	public int modifyMem(String serchId, Member member) {
		//mDao = new MemberDAO();
	int	result = mService.modifyMem(serchId, member);
	return result;
		
	}

	public int serchPwd(String serchPwd, String serchId) {
		//mDao = new MemberDAO();
		int	result = mService.serchPwd(serchPwd, serchId);
		
		return result;
		
	}

}
