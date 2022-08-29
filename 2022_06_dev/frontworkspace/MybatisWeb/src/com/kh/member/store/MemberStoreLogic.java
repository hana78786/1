package com.kh.member.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.vo.Member;

public class MemberStoreLogic implements MemberStore{

	@Override
	public Member PrintMemberById(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member printMemberLogin(SqlSession session, String memberId, String memberPw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> printMemberList(SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int updateMember(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerMember(SqlSession session, Member member) {
		int result= session.insert("MemberMapper.insertMember",member);
		return result;
	}

	@Override
	public int registerMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
