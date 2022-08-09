package member.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.Member;

public class MemberDao {

	public int login(String memberId, String memberPw, Connection conn) {
		
		PreparedStatement pstmt =null;
		ResultSet rset= null;
		int result = 0;
		String sql="select count(*) from member_tbl where member_id = ? and member_pw = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int insertMember(Member member, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into member_tbl values(?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberAge());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getMemberAddress());
			pstmt.setString(8, member.getGender()+"");
			pstmt.setString(9, member.getMemberHobby());
			
			result=pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	public ArrayList<Member> allList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> mList = new ArrayList<Member>();
		String query = "select * from member_tbl";
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));			
				member.setMemberName(rset.getString("member_name"));
				member.setEmail(rset.getString("member_email"));
				member.setMemberAge(rset.getInt("member_age"));
				member.setPhone(rset.getString("member_phone"));
				member.setMemberHobby(rset.getString("member_hobby"));
				member.setMemberAddress(rset.getString("member_address"));
				
				member.setGender(rset.getString("gender").charAt(0));
				member.setEnrollDate(rset.getDate("ENROLLDATE"));
				mList.add(member);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mList;
	}

	public Member mypage(String memberId, Connection conn) {
		Member member= new Member();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		String query ="select * from member_tbl where member_id=?";
				
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset=pstmt.executeQuery();
	
			
			if(rset.next()) {
				member.setMemberId(rset.getString(1));
				member.setMemberName(rset.getString(3));
				member.setMemberAge(rset.getInt(4));
				member.setEmail(rset.getString(5));
				member.setPhone(rset.getString(6));
				member.setMemberAddress(rset.getString(7));
				member.setGender(rset.getString(8).charAt(0));
				member.setMemberHobby(rset.getString(9));
				
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

	public int modifyMember(Member member, Connection conn) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql ="update member_tbl set member_pw=?, member_email=?, member_address=?, gender=?, member_hobby=?, member_phone=? where member_id=?";
	
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getMemberPw() );
			pstmt.setString(2,member.getEmail() );
			pstmt.setString(3,member.getMemberAddress() );
			pstmt.setString(4,member.getGender()+"" );
			pstmt.setString(5,member.getMemberHobby() );
			pstmt.setString(6,member.getPhone() );
			pstmt.setString(7,member.getMemberId() );
			
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

	public int deleteMember(String memberId, Connection conn) {
		int result=0;
		PreparedStatement pstmt =null;
		String sql="delete member_tbl where member_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
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
		
		return result	;
	}

}
	

