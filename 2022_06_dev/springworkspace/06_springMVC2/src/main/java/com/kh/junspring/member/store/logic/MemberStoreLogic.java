package com.kh.junspring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.junspring.member.domain.Member;
import com.kh.junspring.member.store.MemberStore;

//스프링에서 동작하게 하기 위해 반드시 적어야 한다.
@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		Member mOne= session.selectOne("MemberMapper.selectLoginOne",member);
		return mOne;
	}
	@Override
	public Member printOneById(SqlSessionTemplate session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneId", memberId);
		return member;
	}
	
	

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember",member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.update("MemberMapper.deldetMemger",  memberId);
		return result;
	}


}
