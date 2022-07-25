package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Student.Student;

public class Dao {

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD= "student";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	
	public int insertStudent(Student student) {
		
		String query = "insert into student_tbl values('"+student.getStudent_id()+"','"
				+student.getStudent_pwd() +"','"+
				student.getStudent_name()+"','"+
				student.getGender()+"',"+
				student.getAge()+",'"+
				student.getEmail()+"','"+
				student.getPhone()+"','"+
				student.getAddress()+"','"+
				student.getHobby()+"',default)";
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		
		try {
			Class.forName(DRIVER);
			conn= DriverManager.getConnection(URL,USER,PASSWORD);
			stmt=conn.createStatement();
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	
	
	public ArrayList<Student> AllStudent(){
		String query = "select * from student_tbl";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Student> sList = new ArrayList<Student>();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.createStatement();
			rset= stmt.executeQuery(query);
			while(rset.next()) {
				Student student = new Student();
				student.setStudent_id(rset.getString("student_id"));
				student.setStudent_pwd(rset.getString("student_pwd"));
				student.setStudent_name(rset.getString("student_name"));
				student.setAddress(rset.getString("address"));
				student.setAge(rset.getInt("age"));
				student.setEmail(rset.getString("email"));
				student.setGender(rset.getString("gender").charAt(0));
				student.setHobby(rset.getString("hobby"));
				student.setPhone(rset.getString("phone"));
				student.setEnroll_date(rset.getDate("enroll_date"));
				
				sList.add(student);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return sList;
		
	}
	
	public Student serchId(String studentId) {
		String query = "select * from student_tbl where student_id = '"+studentId+"'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Student student = new Student();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
				student.setStudent_id(rset.getString("student_id"));
				student.setStudent_pwd(rset.getString("student_pwd"));
				student.setStudent_name(rset.getString("Student_name"));
				student.setAddress(rset.getString("address"));
				student.setAge(rset.getInt("age"));
				student.setGender(rset.getString("gender").charAt(0));
				student.setHobby(rset.getString("hobby"));
				student.setEmail(rset.getString("email"));
				student.setPhone(rset.getString("phone"));
				student.setEnroll_date(rset.getDate("enroll_date"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return student;
		
	}


	public Student serchname(String studentname) {
		String query = "select * from student_tbl where student_name = '"+studentname+"'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Student student = new Student();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
				student.setStudent_id(rset.getString("student_id"));
				student.setStudent_pwd(rset.getString("student_pwd"));
				student.setStudent_name(rset.getString("Student_name"));
				student.setAddress(rset.getString("address"));
				student.setAge(rset.getInt("age"));
				student.setGender(rset.getString("gender").charAt(0));
				student.setHobby(rset.getString("hobby"));
				student.setEmail(rset.getString("email"));
				student.setPhone(rset.getString("phone"));
				student.setEnroll_date(rset.getDate("enroll_date"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return student;
	}


	public Student updateId(String studentId) {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("바꿀 이름 : ");
		String name = sc.next();
		String query = "update student_tbl set student_name ='"+name+"'"
				+ "where student_id = '"+studentId+"'";
		Connection conn=null;
		Statement stmt = null;
		ResultSet rset = null;		
		
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
				//보류
		return student;
	}


	public Student deleteId(String studentId) {
		String query = "delete student_tbl where student_id='"+studentId+"'";
		Connection conn=null;
		Statement stmt = null;
		ResultSet rset = null;
		Student student = new Student();
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return student;
	}
}
