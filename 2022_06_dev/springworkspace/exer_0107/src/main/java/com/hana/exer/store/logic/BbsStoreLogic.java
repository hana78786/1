package com.hana.exer.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hana.exer.doamin.Bbs;
import com.hana.exer.store.BbsStore;

@Repository
public class BbsStoreLogic implements BbsStore{

	@Override
	public List<Bbs> selectBbsTitle(SqlSessionTemplate session) {
		List<Bbs> bList = session.selectList("bbsMapper.selectTitle");
		return bList;
	}

}
