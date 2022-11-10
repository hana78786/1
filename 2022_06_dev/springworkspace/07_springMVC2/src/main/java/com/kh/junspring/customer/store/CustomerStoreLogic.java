package com.kh.junspring.customer.store;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.junspring.customer.domain.Customer;

@Repository
public class CustomerStoreLogic {

	@Autowired
	private SqlSession sqlSession; // sqlSessionTemplate를 쓰면 결합도가 강함
	//sqlSession은 인터페이스임
	
	public int resgisterCustomer(Customer customer){
		int result = sqlSession.insert("CutomerMapper.insertCustomer",customer);
		return result;
		
	}
}
