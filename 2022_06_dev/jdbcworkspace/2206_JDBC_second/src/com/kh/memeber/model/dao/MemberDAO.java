package com.kh.memeber.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.memeber.model.vo.Member;

public class MemberDAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PWD = "student";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	public ArrayList<Member> allMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> mList = new ArrayList<Member>();
		String query = "select * from member_tbl";

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mList;
	}
//테이블 member_tbl

	public int setMemeber(Member member) {
		Connection conn = null;
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

		String query = "insert into member_tbl values(?,?,?,?,?,?,?,?,?,default)";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public Member serchId(String serchId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select * from member_tbl where member_id = (?)";
		Member member = null;
		ResultSet rset = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public ArrayList<Member> serchName(String serchName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select * from member_tbl where member_name like ?";
		Member member = null;
		ResultSet rset = null;
		ArrayList mList = new ArrayList();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+serchName+"%");
			rset = pstmt.executeQuery();
			

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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return mList;
	}

	public int delMem(String serchId) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete member_tbl where member_id =?";
		
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER, PWD);
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, serchId);
			result = pstmt.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	public int checkId(String serchId) {
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select count(*) from member_tbl where member_id = ?";
		ResultSet rset = null;
		
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER, PWD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, serchId);
			rset=pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	public int modifyMem(String serchId, Member member) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "update member_tbl set member_pwd = ?, member_name =?,gender = ?, email =?, address = ?, phone =?, hobby=?, age=? where member_id= ?";
		
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getGender()+"");
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getHobby());
			pstmt.setInt(8, member.getAge());
			pstmt.setString(9, serchId);
			result = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	public int serchPwd(String serchPwd, String serchId) {
		int result = 0;
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
	//	String query = "select member_pwd from member_tbl where member_id = '"+serchId+"'";
		String query = "select member_pwd from member_tbl where member_id = ?";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
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

			
				
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
