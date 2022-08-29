package com.kh.member.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.member.store.MemberStore;
import com.kh.member.store.MemberStoreLogic;
import com.kh.member.vo.Member;

public class MemberServiceImpl implements MemberStore {

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
	public int registerMember(Member member) {
		SqlSession session= SqlSessionTemplate.getSqlSeesion(); 
		int result = new MemberStoreLogic().registerMember(session, member);
		if(result==1) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
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
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
