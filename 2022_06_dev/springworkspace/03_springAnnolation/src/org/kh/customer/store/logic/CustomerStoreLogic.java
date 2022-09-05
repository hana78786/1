package org.kh.customer.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.kh.customer.domain.Customer;
import org.kh.customer.store.CustomerStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cStore")
public class CustomerStoreLogic implements CustomerStore{
	
	

	@Override
	public List<Customer> selectAll() {
		List<Customer> cList = new ArrayList<Customer>();
		for(int i =0;i<10;i++) {
			Customer cOne = new Customer();
			cOne.setId(i+"");
			cOne.setName(i+"");
			cOne.setAddress(String.valueOf(i));
			cOne.setEmail(new StringBuffer(0).append(i).toString());
		cList.add(cOne);
		}
		return cList;
	}

}
