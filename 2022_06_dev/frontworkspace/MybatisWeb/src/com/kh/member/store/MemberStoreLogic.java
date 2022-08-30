package com.kh.member.store;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.vo.Member;

public class MemberStoreLogic implements MemberStore{

	@Override
	public Member PrintMemberById(SqlSession session, String memberId) {
		Member member = new Member();
		member = session.selectOne("MemberMapper.selectMember",memberId);
		//로직에서 메소드가 하는일은 접속주소를 전달하고 쿼리문을 가지고오고
		//쿼리문에 쓰여질 변수값을 전달하는 일이다
		//이걸로 실행된 쿼리문의 값을 저장하여 반환한다
		System.out.println("로직"+member.getMemberAddress());
		
		
		return member;
	}

	@Override
	public Member printMemberLogin(SqlSession session, String memberId, String memberPw) {
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		Member member = session.selectOne("MemberMapper.selectMemberLogin",param);
		return member;
	}

	@Override
	public ArrayList<Member> printMemberList(SqlSession session) {
		List<Member> mList = session.selectList("MemberMapper.selectAllMember");
		return (ArrayList<Member>)mList;
	}

	
	@Override
	public int updateMember(SqlSession session, Member member) {
		int result= session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember",memberId);
		return result;
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

	@Override
	public ArrayList<Member> printMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member PrintMemberById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
