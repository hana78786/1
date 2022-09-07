package com.kh.exproject.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.exproject.domain.Member;
import com.kh.exproject.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMeber(SqlSessionTemplate session, Member member) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}

}
