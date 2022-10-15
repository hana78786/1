package test.test.test.service.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.test.test.domain.Test;
import test.test.test.service.TestService;
import test.test.test.store.TestStore;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	SqlSessionTemplate session;
	@Autowired
	TestStore tStore;
	
	@Override
	public ArrayList<Test> allMember() {
		ArrayList<Test> tList = tStore.selectAllMember(session);
		return tList;
	}

}
