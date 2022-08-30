package com.kh.member.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.member.store.MemberStore;
import com.kh.member.store.MemberStoreLogic;
import com.kh.member.vo.Member;

public class MemberServiceImpl implements memberService {

	public Member PrintMemberById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		Member member = new Member();
		member= new MemberStoreLogic().PrintMemberById(session, memberId);
		System.out.println(member.getMemberPw());
		session.close();
		
		
		
		return member;
	}

	public Member printMemberLogin(SqlSession session, String memberId, String memberPw) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Member> printMemberList() {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		ArrayList<Member> mList = new MemberStoreLogic().printMemberList(session);
		session.close();
		return mList;
	}

	
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
	public Member printMemberById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member printMemberLogin(String memberId, String memberPw) {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		Member member = new MemberStoreLogic().printMemberLogin(session, memberId, memberPw);
		session.close();
		return member;
	}

	@Override
	public int updateMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		int result= new MemberStoreLogic().updateMember(session, member);
		if(result>0) {
			session.commit();
			
		}else {
			session.rollback();
		}
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSeesion();
		int result= new MemberStoreLogic().deleteMember(session, memberId);
		if(result>0) {
			session.commit();
			
		}else {
			session.rollback();
		}
		return result;
	}
	
	
}
