package test.test.test.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import test.test.test.store.TestStore;

@Repository
public class TestStoreImpl implements TestStore{

	@Override
	public int test(SqlSessionTemplate session) {
	int result=	session.insert("매퍼namespace값,쿼리문id명");
		return result;
	}
	
	

}
