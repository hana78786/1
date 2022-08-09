package com.kh.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.member.dao.MemberDao;
import com.kh.member.model.vo.Member;

import jdk.nashorn.internal.scripts.JD;

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
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result =mDao.insertMember(member, conn);
			if(result==1) {
				JDBCTemplate.commit();
			}else {
				JDBCTemplate.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close();
		}
		return result;
		
	}

	public int memberOneCheck(String memberId, String memberPw) {
	Connection conn=null;
	int isMember=0;
	try {
		conn = jdbcTemplate.createConnection();
		isMember=mDao.selectOneMember(memberId,memberPw, conn);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return isMember;
	}

	public ArrayList<Member> allMemberList() {
		Connection conn;
		ArrayList<Member> mList=null;
		try {
			conn = jdbcTemplate.createConnection();
			mList =mDao.allMemberList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	public Member mypage(String memberId) {
		Connection conn;
		Member member = null;
		try {
			conn=jdbcTemplate.createConnection();
			member = mDao.serchOneId(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return member;
	}

	public int modify(Member member) {
			Connection conn;
			int result=0;
			
			try {
				conn=jdbcTemplate.createConnection();
				result = mDao.modify(member, conn);
				if(result==1) {
					JDBCTemplate.commit();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JDBCTemplate.rollback();
			}finally {
				JDBCTemplate.close();
			}
			return result;
	}

	public int deleteMember(String memberId) {
		Connection conn= null;
		int result =0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result=mDao.deleteMeber(memberId, conn);
			if(result==1) {
				JDBCTemplate.commit();
			}
		} catch (SQLException e) {
			JDBCTemplate.rollback();
			e.printStackTrace();
		}finally {
			JDBCTemplate.close();
		}
		
		
		return result;
	}
		
		
	
}
