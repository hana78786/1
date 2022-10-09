package test.test.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.test.test.domain.Test;
import test.test.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService tService;
	Test test;
	
	@ResponseBody
	@RequestMapping(value="/ajax/test.do", method = RequestMethod.GET)
	public String test(@RequestParam("msg") String result) {
		System.out.println("hi");
		System.out.println(result);
		return result;
	}
}
