package com.kh.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class MemberDao {

	public int insertMember(Member member, Connection conn) {
		PreparedStatement pstmt=null;
		String query="insert into member_tbl values(?,?,?,?,?,?,?,?,?,sysdate)";
		int result=0;
		
		try {
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberAge());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberPhone());
			pstmt.setString(7, member.getMemberAddress());
			pstmt.setString(8, member.getMemberGender()+"");
			pstmt.setString(9, member.getMemberHobby());
			
			result=pstmt.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int selectOneMember(String memberId, String memberPw, Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) as member_count from member_tbl where member_id=? and member_pw=?";
		
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("member_count");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public ArrayList allMemberList(Connection conn) {
		Statement stmt = null;
		ResultSet rSet = null;
		String query="select * from member_tbl";
		ArrayList<Member> mList = new ArrayList<Member>();
		
		try {
			stmt=conn.createStatement();
			rSet=stmt.executeQuery(query);
			while(rSet.next()) {
			Member member=new Member();
			member.setMemberId(rSet.getString("member_id"));			
			member.setMemberName(rSet.getString("member_name"));
			member.setMemberEmail(rSet.getString("member_email"));
			member.setMemberAge(rSet.getInt("member_age"));
			member.setMemberPhone(rSet.getString("member_phone"));
			member.setMemberHobby(rSet.getString("member_hobby"));
			member.setMemberAddress(rSet.getString("member_address"));
			
			member.setMemberGender(rSet.getString("gender").charAt(0));
			member.setEnrollDate(rSet.getDate("ENROLLDATE"));
			mList.add(member);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				rSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mList;
		
	}

	public Member serchOneId(String memberId, Connection conn) {
		Member member = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member_tbl where member_id= ?";
		
		try {
			pstmt= conn.prepareStatement(query);
					pstmt.setString(1, memberId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				member.setMemberId(rset.getString(1));
				member.setMemberName(rset.getString(3));
				member.setMemberAge(rset.getInt(4));
				member.setMemberEmail(rset.getString(5));
				member.setMemberPhone(rset.getString(6));
				member.setMemberAddress(rset.getString(7));
				member.setMemberHobby(rset.getString(9));
				member.setMemberGender(rset.getString(8).charAt(0));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					rset.close();
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		return member;
	}

	public int modify(Member member, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("쿼리문은 실행준비");
		String query =  "UPDATE MEMBER_TBL SET MEMBER_PW = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ? WHERE MEMBER_ID = ?";
		
		System.out.println("쿼리문은 실행");
		
	try {
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberPw());
		pstmt.setString(2, member.getMemberEmail());
		pstmt.setString(3, member.getMemberPhone());
		pstmt.setString(5, member.getMemberHobby());
		pstmt.setString(4, member.getMemberAddress());
		pstmt.setString(6, member.getMemberId());
		
		result=pstmt.executeUpdate();
		System.out.println("result값 확인"+result);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		return result;
		
	}

	public int deleteMeber(String memberId, Connection conn) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="delete from member_tbl where member_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	

}
