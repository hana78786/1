package com.kh.member.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.vo.Member;

public interface MemberStore {
	//printMemberByid
	//printMemberLogin
	//printMemberList
	
	public Member PrintMemberById(SqlSession session, String memberId);
	public Member printMemberLogin(SqlSession session, String memberId, String memberPw);
	public ArrayList<Member> printMemberList(SqlSession session);	
	
	
	public int registerMember(SqlSession session, Member member);
	public int updateMember(SqlSession session, Member member);
	public int deleteMember(SqlSession session, String memberId);
	int registerMember(Member member);
}
