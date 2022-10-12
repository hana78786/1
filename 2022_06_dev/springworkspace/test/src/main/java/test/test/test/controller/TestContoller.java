package test.test.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.test.test.domain.Test;
import test.test.test.service.TestService;

@Controller
public class TestContoller {
	
	@Autowired
	TestService tService;
	
	
	
	@ResponseBody
	@RequestMapping(value="/test.do", produces = "application/json;charshet=utf-8", method = RequestMethod.GET)
	public String allMember() {
		ArrayList<Test> tList = tService.allMember();
		
		return new Gson().toJson(tList).toString();
	}
	

}
