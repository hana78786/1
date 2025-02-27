package com.hana.exer.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.exer.doamin.Bbs;
import com.hana.exer.service.BbsSerivce;
import com.hana.exer.store.BbsStore;

@Service
public class BbsSerivceLogic implements BbsSerivce {

	@Autowired
	BbsStore bStore;
	@Autowired
	SqlSessionTemplate session;
	@Override
	public List<Bbs> bbsTitle() {
		List<Bbs> bList = bStore.selectBbsTitle(session);
		return bList;
	}
	@Override
	public int resgitBbs(Bbs bbs) {
		int result = bStore.insertBbs(session,bbs);
		return result;
	}
	@Override
	public Bbs readBbsOne(int bbsNo) {
		Bbs bbs = bStore.selectOneBbs(session, bbsNo);
		return bbs;
	}
	@Override
	public int checkName(String name) {
		int result = bStore.selectOneNameChek(session,name);
		return result;
	}
	@Override
	public int modifyOneBBs(Bbs bbs) {
		int result = bStore.updateOnebbs(session,bbs);
		return result;
	}
	
	
}
