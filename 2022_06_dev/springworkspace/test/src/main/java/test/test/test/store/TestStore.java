package test.test.test.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import test.test.test.domain.Test;

public interface TestStore {

	ArrayList<Test> selectAllMember(SqlSessionTemplate session);

}
