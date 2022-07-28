package com.kh.memeber.model.dao;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.memeber.common.JDBCTemplate;
import com.kh.memeber.model.vo.Member;

public class MemberDAO {
	private Properties prop = new Properties();

	public ArrayList<Member> allMember(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> mList = new ArrayList<Member>();
		
		try {
			FileReader fReader = new FileReader("resources/query.properties");
			prop.load(fReader);
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = prop.getProperty("queryAll");

		try {

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setMemberName(rset.getString("member_name"));
				member.setAddress(rset.getString("address"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setGender(rset.getString("gender").charAt(0));
				member.setHobby(rset.getString("hobby"));
				member.setPhone(rset.getString("phone"));
				member.setEnRollDate(rset.getDate("enroll_date"));

				mList.add(member);
			}

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
		}
			
		return mList;
		}

	
//테이블 member_tbl

	public int setMemeber(Connection conn, Member member) {
		
		// Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		/*
		 * String query = "insert into member_tbl values ('"+member.getMemberId()+"','"
		 * +member.getMemberPwd()+"','" +member.getMemberName()+"','"
		 * +member.getGender()+"'," +member.getAge()+",'" +member.getEmail()+"','"
		 * +member.getPhone()+"','" +member.getAddress()+"','" +member.getHobby()+"',"
		 * +"default)";
		 */
		try {
			FileReader fReader = new FileReader("resources/query.properties");
			prop.load(fReader);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = prop.getProperty("insertQuery");
		try {

			// stmt = conn.createStatement();
			// result = stmt.executeUpdate(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender() + "");
			// pstmt.setString(4, String.valueOf(member.getGender()+""));
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(9, member.getHobby());

			// Ctrl+Enter
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public Member serchId(String serchId, Connection conn) {
		
		PreparedStatement pstmt = null;
		
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String query = prop.getProperty("idQuery");
		Member member = null;
		ResultSet rset = null;

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, serchId);
			rset = pstmt.executeQuery();
			

			if (rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPwd(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setGender(rset.getString(4).charAt(0));
				member.setAge(rset.getInt(5));
				member.setEmail(rset.getString(6));
				member.setPhone(rset.getString(7));
				member.setAddress(rset.getString(8));
				member.setHobby(rset.getString(9));
				member.setEnRollDate(rset.getDate(10));
			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return member;
	}

	public ArrayList<Member> serchName(String serchName, Connection conn) {

		PreparedStatement pstmt = null;
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String query = prop.getProperty("nameQuery");  //?위치홀더
		Member member = null;
		ResultSet rset = null;
		ArrayList mList = new ArrayList();
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+serchName+"%");
			rset = pstmt.executeQuery(); //Ctrl+Enter의 의미
			

			while (rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPwd(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setGender(rset.getString(4).charAt(0));
				member.setAge(rset.getInt(5));
				member.setEmail(rset.getString(6));
				member.setPhone(rset.getString(7));
				member.setAddress(rset.getString(8));
				member.setHobby(rset.getString(9));
				member.setEnRollDate(rset.getDate(10));
				mList.add(member);
			} 

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mList;
	}

	public int delMem(Connection conn, String serchId) {
	
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("delQuery");
		
		try {
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, serchId);
			result = pstmt.executeUpdate();
			
			
			
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

	public int checkId(Connection conn, String serchId) {
		int result=0;
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("countId");
		ResultSet rset = null;
		
		try {
			
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, serchId);
			rset=pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
			
			
			
		}  catch (SQLException e) {
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

	public int modifyMem(String serchId, Member member, Connection conn) {
		int result = 0;
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateMember");
		
		try {

			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberName());
			
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getHobby());
	
			pstmt.setString(7, serchId);
			result = pstmt.executeUpdate();
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
				
		
		
		
		return result;
	}

	public int serchPwd(String serchPwd, String serchId, Connection conn) {
		int result = 0;
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("checkPwd");
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, serchId);
			rset = pstmt.executeQuery();
			//stmt= conn.createStatement();
			//rset = stmt.executeQuery(query);
			
			if(rset.next()) {	
				if(rset.getString("member_pwd").equals(serchPwd)) {
					result = 1;
				}
				
				
			}

			
				
			
			
			
		}  catch (SQLException e) {
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

}
