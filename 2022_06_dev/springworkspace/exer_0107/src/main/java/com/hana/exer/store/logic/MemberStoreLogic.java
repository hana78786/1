package com.hana.exer.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hana.exer.doamin.Member;
import com.hana.exer.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMember(Member member,  SqlSessionTemplate session) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}
	

}
