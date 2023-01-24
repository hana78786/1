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

	@Override
	public int insertBbs(SqlSessionTemplate session, Bbs bbs) {
		int result = session.insert("bbsMapper.insertBbs",bbs);
		return result;
	}

	@Override
	public Bbs selectOneBbs(SqlSessionTemplate session, int bbsNo) {
		Bbs bbs = session.selectOne("bbsMapper.selectOnebbs",bbsNo);
		return bbs;
	}

	@Override
	public int selectOneNameChek(SqlSessionTemplate session, String name) {
		int result = session.selectOne("bbsMapper.selectOneNameCheck",name);
		return result;
	}

	@Override
	public int updateOnebbs(SqlSessionTemplate session, Bbs bbs) {
		int result = session.update("bbsMapper.updateOnebbs",bbs);
		return result;
	}

}
