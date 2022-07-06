package com.kh.member.controller;

import java.util.ArrayList;

import com.kh.member.model.vo.Member;

public class Controller {

	private ArrayList<Member> mList;

	public Controller() {
		mList = new ArrayList<Member>();

	}

	public void registerMember(Member member) {
		mList.add(member);
	}

	public ArrayList<Member> printAllMember() {
		return mList;
	}

	public void removeMember(int index) {
		mList.remove(index);
	}

	public int findMeberId(String memberId) {
		for (int i = 0; i < mList.size(); i++) {
			Member mOne = mList.get(i);
			if (memberId.equals(mOne.getMemberId())) {
				return i;
			}
			
		}
		return -1;
	}
	

	public int findMeberName(String memberName) {
		for (int i = 0; i < mList.size(); i++) {
			Member mOne = mList.get(i);
			if (memberName.equals(mOne.getMemberName())) {
				return i;
			}		
		}
		return -1;
	}
	
	public Member pirntOneById(int index) {
		Member member = mList.get(index);
		return member;
	}
}
