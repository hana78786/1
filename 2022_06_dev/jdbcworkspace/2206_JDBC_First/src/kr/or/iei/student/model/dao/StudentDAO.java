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
		ArrayList<Student> sList= new ArrayList<Student>();


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
				
				
				
			//	student.setEnrollDAte(Integer.parseInt(rset.getString("ENROLL_DATE")));
				
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
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		return sList;

	}

}
