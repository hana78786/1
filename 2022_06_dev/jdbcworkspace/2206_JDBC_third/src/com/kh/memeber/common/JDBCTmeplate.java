package com.kh.memeber.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//DB연결작업을 할 클래스
public class JDBCTmeplate {
	private Properties prop = new Properties();

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

	public Connection createConnection() throws ClassNotFoundException, SQLException {

		try {
			FileReader fReader = new FileReader("resources/driver.properties");
			prop.load(fReader);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
			if (conn == null || conn.isClosed()) {
				Class.forName(driver);
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
