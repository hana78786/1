package com.kh.junspring.ajax.controller;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.junspring.member.domain.Member;

@Controller
public class AjaxController {
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
				member = mOne;}
		}
		
		System.out.println(member.toString());
		JSONObject jsonObj = new JSONObject();// json객체 생성 -> {} 생성완료
		jsonObj.put("memberId", member.getMemberId());
		jsonObj.put("memberPwd", member.getMemberPw());

		// {"userNo":1,"userName":일용자,"userAddr":"서울시 중구"}
//		jsonObj.put("userNo", 1);
//		jsonObj.put("userName", "일용자");
//		jsonObj.put("userAddr", "서울시 중구");
		return jsonObj.toString();
	}

}
