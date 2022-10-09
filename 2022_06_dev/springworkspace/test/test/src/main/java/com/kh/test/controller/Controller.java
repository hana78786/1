package com.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.test.service.Service;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	Service service;
	
	@RequestMapping(value="/test.do", method = RequestMethod.GET)
	public void test() {
		int result = service.test();
		System.out.println(result);
		
	}

}
