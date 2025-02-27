package com.books.peanut.member.service;

import com.books.peanut.member.domain.Member;

public interface MemberService {
	// 회원가입
	int registerMember(Member member);
	// 별명 유효성 검사
	int checkNickname(String mNickname);
	// 아이디 유효성 검사
	int checkId(String memberId);
	// 이메일 유효성 검사
	int checkEmail(String mEmail);
	// 로그인
	Member loginMember(Member member);
	// 회원 정보 수정
	int modifyInfo(Member member);
	// 회원탈퇴
	int deleteMember(Member member);
	// 내 서재 - 저장된 도서 수 가져오기
//	int countSavedBooks(String memberId);
	// 로그인한 회원이 등록한 작품 수 가져오기
	int countWrittenBooks(String memberId);
	

}
