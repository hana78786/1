package com.hana.exer.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.exer.doamin.Member;
import com.hana.exer.service.MemberService;
import com.hana.exer.store.MemberStore;

@Service
public class MemberServiceLogic implements MemberService {
	@Autowired
	MemberStore mStore;
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public int registMember(Member member) {
		int result = mStore.insertMember(member, session);
		return result;
	}

}
