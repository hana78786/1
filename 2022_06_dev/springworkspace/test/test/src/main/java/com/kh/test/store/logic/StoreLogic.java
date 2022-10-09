package com.kh.test.store.logic;

import org.springframework.stereotype.Repository;

import com.kh.test.store.Store;

@Repository
public class StoreLogic implements Store {

	@Override
	public int test() {
		int result = 15;
		return result;
	}

}
