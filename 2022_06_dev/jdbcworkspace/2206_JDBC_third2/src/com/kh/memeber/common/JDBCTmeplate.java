package com.kh.memeber.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB연결작업을 할 클래스
public class JDBCTmeplate {

	private static JDBCTmeplate instance;
	// 객체의 존재 유무를 판단하기 위해 선언한 static 변수

	private static Connection conn;

	private JDBCTmeplate() {
	}

	public static JDBCTmeplate getInstatnce() {
		if (instance == null) {
			instance = new JDBCTmeplate();
		}
		return instance;
	}

	public static Connection createConnection() throws ClassNotFoundException, SQLException {

//		if (conn != null) {
//			return conn;
//			
//		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";

		
			if (conn == null || conn.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false); //자동커밋해제
				
			}

	

		return conn;

	}

	public void close() {
		
			if (conn != null) {
				try {
					if (!conn.isClosed()) {
						conn.close();

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	public void rollback() {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
