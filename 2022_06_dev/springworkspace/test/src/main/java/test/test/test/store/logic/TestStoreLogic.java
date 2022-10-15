package test.test.test.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import test.test.test.domain.Test;
import test.test.test.store.TestStore;

@Repository
public class TestStoreLogic implements TestStore {

	@Override
	public ArrayList<Test> selectAllMember(SqlSessionTemplate session) {
		List<Test> tList = session.selectList("testMapper.memberSelect");
		return (ArrayList<Test>)tList;
	}
	
	

}
