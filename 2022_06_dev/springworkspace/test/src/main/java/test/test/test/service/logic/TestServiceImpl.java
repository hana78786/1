package test.test.test.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.test.test.service.TestService;
import test.test.test.store.TestStore;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	SqlSessionTemplate session;
	@Autowired
	TestStore tStore;
	@Override
	public int test() {
		int result = tStore.test(session);
		return 0;
	}
}
