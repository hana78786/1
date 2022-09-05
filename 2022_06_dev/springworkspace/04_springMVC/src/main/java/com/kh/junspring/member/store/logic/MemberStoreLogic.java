package com.kh.junspring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.junspring.member.domain.Member;
import com.kh.junspring.member.store.MemberStore;

//스프링에서 동작하게 하기 위해 반드시 적어야 한다.
@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId, String memberPw) {
		// TODO Auto-generated method stub
		return 0;
	}

}
