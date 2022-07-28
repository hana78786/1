package com.kh.memeber.controller;

import java.util.ArrayList;

import com.kh.memeber.model.dao.MemberDAO;
import com.kh.memeber.model.service.Service;
import com.kh.memeber.model.vo.Member;

public class MemberController {
	
	
	
	
	public ArrayList<Member> allMember() {
		Service service = new Service();
		ArrayList<Member> mList = service.allMember();
		return mList;
	}

	public int setMember(Member member) {
		Service service = new Service();
		int result = service.setMemeber(member);

		return result;
	}

	public Member serchId(String serchId) {
		Service service = new Service();
	 Member member= service.serchId(serchId);
		
	
		return  member ;
	}

	public ArrayList<Member> serchName(String serchName) {
		Service service = new Service();
		ArrayList<Member> mList = service.serchName(serchName);
			
			
			return mList ;
	}

	public int delMem(String serchId) {
		Service service = new Service();
		int result = service.delMem(serchId);
		return result;
	}

	public int checkId(String serchId) {
		Service service = new Service();
		int result = service.checkId(serchId);
		return result;
	}

	public int modifyMem(String serchId, Member member) {
		Service service = new Service();
	int	result = service.modifyMem(serchId, member);
	return result;
		
	}

	public int serchPwd(String serchPwd, String serchId) {
		Service service = new Service();
		int	result = service.serchPwd(serchPwd, serchId);
		
		return result;
		
	}

}
