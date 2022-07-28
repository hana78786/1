package MemberTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MemberTest.Member.Member;

public class DAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	ArrayList<Member> list = null;
	

	
	
	
	public ArrayList<Member> allList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from member_tbl";
		
		try {
			Class.forName(DRIVER);
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			list = new ArrayList<Member>();
			
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setGender(rset.getString("gender").charAt(0));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEndrollDate(rset.getDate("enroll_date"));
				
				list.add(member);
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
		
		
		return list;
	}





	public Member idList(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member_tbl where member_id = ?";
		Member member =null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);		
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
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
				member.setEndrollDate(rset.getDate(10));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}





	public ArrayList<Member> nameList(String name) {
		ArrayList<Member> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member_tbl where member_name like ?";
	
		
		
		try {
			Class.forName(DRIVER);
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+name+"%");
			rset= pstmt.executeQuery();
			
			
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPwd(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setGender(rset.getString(4).charAt(0));
				member.setAge(rset.getInt(5));
				member.setEmail(rset.getString(6));
				member.setPhone(rset.getString(7));
				member.setAddress(rset.getString(8));
				member.setHobby(rset.getString(9));
				member.setEndrollDate(rset.getDate(10));
				
				list.add(member);
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
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return list;
	}





	public int insertMember(Member member) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0 ;
		String query = "insert into member_tbl values('"
				+member.getMemberId() +"','"
				+member.getMemberPwd() +"','"
				+member.getMemberName() +"','"
				+member.getGender() +"',"
				+member.getAge()+",'"
				+member.getEmail()+"','"
				+member.getPhone()+"','"
				+member.getAddress() +"','"
				+ member.getHobby()+"',"
				+"sysdate"
				+ ")";
		
		try {
			Class.forName(DRIVER);
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}





	public int checkId(String id) {
		int count=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from member_tbl where member_id = ?";
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return count;
	}





	public int updateMember(Member member) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		String sql = "update member_tbl set member_name ='"+member.getMemberName()+"',"+
					"member_pwd='"+member.getMemberPwd()+"',"+
					"age="+member.getAge()+","+
					"email = '"+member.getEmail()+"',"+
					"phone = '"+member.getPhone()+"',"+
					"hobby = '"+member.getHobby()+"',"+
					"address = '"+member.getAddress()+"' where member_id = '"+member.getMemberId()+"'";
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}





	public int delMember() {
		
		
		
		
		
		return 0;
	}





	public int delMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete member_tbl where member_id = ?";
		
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}

}
