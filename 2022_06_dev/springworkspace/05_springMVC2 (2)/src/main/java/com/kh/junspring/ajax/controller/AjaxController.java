package com.kh.junspring.ajax.controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kh.junspring.member.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AjaxController {
	
	private static Logger log = LoggerFactory.getLogger(AjaxController.class);
	
	@ResponseBody
	@RequestMapping(value = "/ajax/ex1.kh", method = RequestMethod.GET)
	public void exerciseAjax(@RequestParam("msg") String msg) {
		System.out.println("전송받은 데이터 : " + msg);

	}

	@RequestMapping(value = "/ajax/ex.kh", method = RequestMethod.GET)
	public String viewExajax() {
		return "/ajax/ajaxExercuse";
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/ex2.kh", produces = "text/plain;charset=utf-8", // utf-8로 인코딩해주는 코드
			method = RequestMethod.GET)
	public String eserciseAjax2() {
		

		return "서버에서 왔습니다";

	}

	@ResponseBody
	@RequestMapping(value = "/ajax/ex3.kh", produces = "text/plain;charset=utf-8", // utf-8로 인코딩해주는 코드
			method = RequestMethod.GET)
	public String eserciseAjax3(@RequestParam("num1") Integer first, @RequestParam("num2") Integer second) {

		int result = first + second;
		log.debug(result+"");
		return String.valueOf(result);

	}

	@ResponseBody
	@RequestMapping(value = "/ajax/ex4.kh", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String exerciseAjax4(@RequestParam("userId") String memberId) {
		System.out.println(memberId);
		ArrayList<Member> mList = new ArrayList<Member>();
		mList.add(new Member("khuser01", "pass01"));
		mList.add(new Member("khuser02", "pass02"));
		mList.add(new Member("khuser03", "pass03"));
		mList.add(new Member("khuser04", "pass04"));
		mList.add(new Member("khuser05", "pass05"));
		mList.add(new Member("khuser06", "pass06"));
		Member member = null;
		for (Member mOne : mList) {
			if (mOne.getMemberId().equals(memberId)) {
				member = mOne;
			}
		}

		System.out.println(member.toString());
		JSONObject jsonObj = new JSONObject();// json객체 생성 -> {} 생성완료
		jsonObj.put("memberId", member.getMemberId());
		jsonObj.put("memberPwd", member.getMemberPw());

		return jsonObj.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/ex5.kh", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String exerciseAjax5(@RequestParam("memberId") String memberId) {

		ArrayList<Member> mList = new ArrayList<Member>();
		mList.add(new Member("khuser01", "pass01"));
		mList.add(new Member("khuser02", "pass02"));
		mList.add(new Member("khuser03", "pass03"));
		mList.add(new Member("khuser04", "pass04"));
		mList.add(new Member("khuser05", "pass05"));
		mList.add(new Member("khuser06", "pass06"));

		// json Array로 만들기
		JSONArray jsonArr = new JSONArray(); // [ ]배열생성

		boolean check = false;

		for (Member member : mList) {
			if (member.getMemberId().equals(memberId)) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("memberId", member.getMemberId());
				jsonObj.put("memberPw", member.getMemberPw());
				jsonArr.add(jsonObj);
				check = true;
				break;
			}

		}
		if (!check) {
			for (Member member : mList) {
				JSONObject jsonObj = new JSONObject(); // { }객체생성
				jsonObj.put("memberId", member.getMemberId());
				jsonObj.put("memberPw", member.getMemberPw());
				jsonArr.add(jsonObj);
			}

		}

		return jsonArr.toString();
	}

	@ResponseBody // 코드 정상이었는데 이거 없어서 전달안됨!!
	@RequestMapping(value = "ajax/ex6.kh", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	public String exerciseAjax() {


		ArrayList<Member> mList = new ArrayList<Member>();
		mList.add(new Member("khuser01", "pass01"));
		mList.add(new Member("khuser02", "pass02"));
		mList.add(new Member("khuser03", "pass03"));
		mList.add(new Member("khuser04", "pass04"));
		mList.add(new Member("khuser05", "pass05"));
		mList.add(new Member("khuser06", "pass06"));

		Gson gson = new Gson();
		System.out.println(gson.toJson(mList));
		return gson.toJson(mList); //mList를 json으로 바꿔줌

	}

}
