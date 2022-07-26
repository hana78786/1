package kr.or.iei.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kr.or.iei.student.model.vo.Student;

public class StudentDAO {

	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "student";
	private final String password = "student";
	private final String driver = "oracle.jdbc.driver.OracleDriver";

	public int insertStudent(Student student) {
		// JDBC절차대로 코딩을 해서 넘겨받은 student 정보를 DB에 저장
		/*
		 * 1.드라이버 등록 2.DBMS 연결 3.statement 생성 -> 쿼리문실행 4.쿼리문 실행 5. 결과값 받기 (ResultSet) ->
		 * 콘솔 출력 6. 자원해제 (close)
		 */
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		String query = "insert into student_tbl values('" + student.getStudentId() + "','" + student.getStudentPwd()
				+ "','" + student.getStudentName() + "','" + student.getGender() + "'," + student.getAge() + ",'"
				+ student.getEmail() + "','" + student.getPhone() + "','" + student.getAddress() + "','"
				+ student.getHobby() + "',default)";

		Connection conn = null;
		Statement stmt = null;
		// ResultSet rset = null; //ddl
		int result = 0; // dml
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public ArrayList<Student> AllStu() {

		String query = "select * from student_tbl";
		Connection conn = null; // 연결객체
		Statement stmt = null; // 쿼리문 실행
		ResultSet rset = null; // 결과값
		ArrayList<Student> sList = new ArrayList<Student>();

		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, user, password); // 2
			stmt = conn.createStatement();// 3
			rset = stmt.executeQuery(query);// 4, 5
			while (rset.next()) {
				Student student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setGender(rset.getString("GENDER").charAt(0));

				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setHobby(rset.getString("HOBBY"));

				student.setEnrollDAte(rset.getDate("enroll_date"));

				sList.add(student);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return sList;

	}

	public Student selectOnebyid(String studentId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Student student = null;
		String query = "select * from student_tbl where student_id ='" + studentId + "'";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			student = new Student();
			if (rset.next()) {
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setGender(rset.getString("GENDER").charAt(0));

				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setHobby(rset.getString("HOBBY"));

				student.setEnrollDAte(rset.getDate("enroll_date"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return student;
	}

	public ArrayList<Student> selectByName(String studentName) {
		ArrayList<Student> sList = new ArrayList<Student>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from student_tbl where student_name like '%" + studentName + "%'";

		try {
			Class.forName(driver);// 1
			conn = DriverManager.getConnection(url, user, password);// 2
			stmt = conn.createStatement();// 4,5
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				Student student = new Student();
				student.setStudentId(rset.getString("student_id"));
				student.setStudentPwd(rset.getString("student_pwd"));
				student.setStudentName(rset.getString("Student_Name"));
				student.setAge(rset.getInt("age"));
				student.setAddress(rset.getString("address"));
				student.setGender(rset.getString("gender").charAt(0));
				student.setEmail(rset.getString("email"));
				student.setPhone(rset.getString("phone"));
				student.setHobby(rset.getString("hobby"));
				student.setEnrollDAte(rset.getDate("enroll_date"));

				sList.add(student);
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

		return sList;
	}

	public int removeStu(String studentId) {
		Connection conn = null;
		Statement stmt = null;

		String query = "delete student_tbl where student_id = '" + studentId + "'";

		int result = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public int checkId(String studentId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) as student_id from student_tbl where student_id = '" + studentId + "'";

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				result = rset.getInt("student_id");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public int modifyStudent(Student student) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query = "update student_tbl "+
				"set student_name ='"+student.getStudentName()+"',"
				+"student_pwd = '"+student.getStudentPwd()+"',"
				+"address = '"+student.getAddress()+"',"
				+"hobby = '"+student.getHobby()+"'"
				+ "where student_id ='"+student.getStudentId()+"'";
		
		try {
			
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,password);
			stmt=conn.createStatement();
			result=stmt.executeUpdate(query);
			
			
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
