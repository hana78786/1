package org.kh.customer.main;

import java.util.List;

import org.kh.customer.domain.Customer;
import org.kh.customer.service.CustomerService;
import org.kh.customer.service.logic.CustomerServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerRun {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");

	CustomerService cService = (CustomerServiceImple)ctx.getBean("customerService");
	List<Customer> cList= cService.findA11();
	for(Customer cOne : cList) {
		System.out.println(cOne.toString());
		
	}
	}

}
