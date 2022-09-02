package org.kh.customer.service.logic;

import java.util.List;

import org.kh.customer.domain.Customer;
import org.kh.customer.service.CustomerService;
import org.kh.customer.store.CustomerStore;
import org.kh.customer.store.logic.CustomerStoreLogic;

public class CustomerServiceImple implements CustomerService{
	//private CustomerStoreLogic cStore //현재 강한결합상태 해소하기 위해 인터페이스로 바꾼다
	private CustomerStore cStore; 
	
	
	public void setStore(CustomerStore cStore) {
		this.cStore = cStore;
	}//이게 DI를 만들기 위해 만든 setter
	
	
	
	//인터페이스로 선언하여 강한결합을 해소할수있다.
	//강한결합을 해소하지 않으면 CustomerStoreLogic이 변화될때마다 고쳐줘야함
	//유지보수의 편리성
	//결합을 해소하는 방법 DI 의존성 주입
	
	
	//public CustomerServiceImple() {
		//cStore = new CustomerStoreLogic(); //DI로 이 결합을 해소할것임
		
	//}
	
	@Override
	public List<Customer> findA11() {
		List<Customer> cList = new CustomerStoreLogic().selectAll();
		return cList;
	}

}
