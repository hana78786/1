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
			conn.setAutoCommit(false);
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
			if(result==1) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
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

	

}
