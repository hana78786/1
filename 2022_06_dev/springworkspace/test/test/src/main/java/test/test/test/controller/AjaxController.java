package test.test.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import test.test.test.domain.Test;

@Controller
public class AjaxController {

	@ResponseBody
	@RequestMapping(value = "/ajax/ajax.do", method = RequestMethod.GET)
	public String test1(@RequestParam("test") String test) {
		System.out.println(test);
		return "¼º°ø";

	}

	@ResponseBody
	@RequestMapping(value = "/ajax/ajax3.do", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String test3(@RequestParam("id") String id) {
		ArrayList<Test> tList = new ArrayList<Test>();
		tList.add(new Test("user01", "pass01"));
		tList.add(new Test("user02", "pass02"));
		tList.add(new Test("user03", "pass03"));
		tList.add(new Test("user04", "pass04"));
		tList.add(new Test("user05", "pass05"));

		boolean check = false;
		Gson gson = new Gson();
		ArrayList<Test> tList1 = null;
		
		for (Test test : tList) {
			if (test.getId().equals(id)) {
				tList.add(test);

				check = true;
				break;
			}
		}

	
		

		

		return gson.toJson(tList);
	}

}
