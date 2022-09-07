package com.kh.exproject.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.exproject.domain.Member;

public interface MemberStore {

	int insertMeber(SqlSessionTemplate session, Member member);

}
