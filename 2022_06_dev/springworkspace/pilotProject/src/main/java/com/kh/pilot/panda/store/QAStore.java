package com.kh.pilot.panda.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.pilot.panda.domain.QA;

public interface QAStore {
	
	public int insertQandA(QA qa,SqlSessionTemplate session);

	public int updateQandA(QA qa,SqlSessionTemplate session);

	public int deleteOneQandANo(int qaNo, SqlSessionTemplate session);

	public QA selectOneQANo(int qaNo, SqlSessionTemplate session);

	public List<QA> selectallQAList(int currentPage, int limit, SqlSessionTemplate session);

}
