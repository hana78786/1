package com.kh.exproject.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.exproject.domain.Member;
import com.kh.exproject.service.MemberService;
import com.kh.exproject.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	SqlSessionTemplate session;
	@Autowired
	MemberStore mStore;

	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMeber(session, member);
		return result;
	}

}
