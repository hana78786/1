package com.kh.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.member.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	MemberDao mDao;
	//1. DB연결생성
	//2. 커밋/롤백
	private JDBCTemplate jdbcTemplate;
	public MemberService() {
		jdbcTemplate=JDBCTemplate.getInstance();
		 mDao= new MemberDao();
	}
	
	public int insertMember(Member member) {
		Connection conn = jdbcTemplate.createConnection();
		int result =mDao.insertMember(member, conn);
		
		return result;
		
	}

	public int memberOneCheck(String memberId, String memberPw) {
	Connection conn= jdbcTemplate.createConnection();
	int isMember=mDao.selectOneMember(memberId,memberPw, conn);
		return isMember;
	}

	public ArrayList<Member> allMemberList() {
		Connection conn = jdbcTemplate.createConnection();
		ArrayList<Member> mList;
		mList =mDao.allMemberList(conn);
		return mList;
	}
}
