package com.kh.junspring.member.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.junspring.member.domain.Member;
import com.kh.junspring.member.service.MemberService;
import com.kh.junspring.member.store.MemberStore;
import com.kh.junspring.member.store.logic.MemberStoreLogic;

//스프링에서 동작하게 하기 위해 반드시 적어야 한다.
@Service
public class MemberServicImpl implements MemberService{
	
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private MemberStore mStore;
	
	@Override
	public Member loginMember(Member member) {
		Member mOne = mStore.selectLoginMember(session, member);
		return mOne;
	}

	@Override
	public int registerMember(Member member) {
		
		int result=mStore.insertMember(session, member);
		
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(session, member);
		return result;
	}

	@Override
	public int removeMember(String memberId) {
		int result = mStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public Member printOneById(String memberId) {
		Member member = mStore.printOneById(session, memberId);
		
		return member;
	}

	@Override
	public int checkOneId(String memberId) {
		int result = mStore.selectOneById(memberId, session);
		return result;
	}

}
