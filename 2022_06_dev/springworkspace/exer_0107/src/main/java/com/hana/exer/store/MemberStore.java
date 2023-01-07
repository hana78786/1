package com.hana.exer.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.hana.exer.doamin.Member;

public interface MemberStore {

	int insertMember(Member member, SqlSessionTemplate session);

}
