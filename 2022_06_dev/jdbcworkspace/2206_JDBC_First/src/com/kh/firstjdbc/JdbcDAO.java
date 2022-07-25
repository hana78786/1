package com.kh.firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDAO {
//DB에 접속해서 memeber_tml 테이블의 정보를 console에 출력하시오

	/*
	 * 1. 드라이버 등록 2. DBMS 연결 생성 3. Statement 객체생성 : 쿼리문실행 4. sql전송(쿼리문 실행) 5. 결과값 받기
	 * 6. 자원해제
	 */
	public static void main(String args[]) {

		String url= "jdbc:oracle:thin:@localhost:1521:XE";
		String user= "student";
		String passwrod = "student";
		String query= "select * from member_tbl";
		
		
		Connection conn = null; //연결객체
		Statement stmt = null; //쿼리문 실행
		ResultSet rset = null; //결과값
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1
			conn=DriverManager.getConnection(url,user,passwrod); //2
			stmt = conn.createStatement();//3
			rset = stmt.executeQuery(query);//4, 5
			while(rset.next()) {
				System.out.println(rset.getString("Member_id")+"," + rset.getString("member_name"));
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
		
		
	}
}
