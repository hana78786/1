package com.kh.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.vo.Member;

public interface memberService {
	public Member printMemberById(String memberId);
	public Member printMemberLogin(String memberId, String memberPw);
	public int registerMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String memberId);

}
