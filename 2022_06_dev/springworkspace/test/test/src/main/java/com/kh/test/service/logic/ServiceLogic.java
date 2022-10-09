package com.kh.test.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.store.Store;

@Service
public class ServiceLogic implements com.kh.test.service.Service {

	@Autowired
	SqlSessionTemplate session;
	@Autowired
	Store store;
	
	@Override
	public int test() {
		int result = store.test();
		return result;
	}
	

}
