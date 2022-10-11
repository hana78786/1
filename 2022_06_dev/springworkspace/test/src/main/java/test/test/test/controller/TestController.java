package test.test.test.controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import test.test.test.domain.Test;
import test.test.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService tService;

	public void test() {
		int result = tService.test();
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/test1.do", method = RequestMethod.GET)
	public String test1(@RequestParam("test1") String test1) {
		System.out.println(test1);

		return test1;
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/test3.do", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String test3(@RequestParam("test3") String test3) {
		ArrayList<Test> tList = new ArrayList<Test>();
		tList.add(new Test("user01", "pass01"));
		tList.add(new Test("user02", "pass02"));
		tList.add(new Test("user03", "pass03"));
		tList.add(new Test("user04", "pass04"));

		JSONArray jsonArr = new JSONArray();
		boolean check = false;
		for (Test test : tList) {
			if (test.getMemberId().equals(test3)) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("memberId", test.getMemberId());
				jsonObj.put("memberPwd", test.getMemberPwd());
				jsonArr.add(jsonObj);
				check = true;
				break;
			}
		}

		if (!check) {
			for (Test test : tList) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("memberId", test.getMemberId());
				jsonObj.put("memberPwd", test.getMemberPwd());
				jsonArr.add(jsonObj);

			}
		}

		return jsonArr.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/test4.do", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String test4(@RequestParam("test3") String test3) {
		ArrayList<Test> tList = new ArrayList<Test>();
		tList.add(new Test("user01", "pass01"));
		tList.add(new Test("user02", "pass02"));
		tList.add(new Test("user03", "pass03"));
		tList.add(new Test("user04", "pass04"));

		boolean check = false;
		ArrayList<Test> tList1 = new ArrayList<Test>();
		for (Test test : tList) {
			if (test.getMemberId().equals(test3)) {
				tList1.add(test);
				check = true;
				break;
			}
		}

		Gson gson = new Gson();
		if (!check) {
			for(Test test:tList) {
				tList1.add(test);
			}
		}
		
		
		return gson.toJson(tList1);

	}
}
