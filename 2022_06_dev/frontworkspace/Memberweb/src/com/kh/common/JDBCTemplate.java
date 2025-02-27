package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	private static JDBCTemplate instance;
	private static Connection conn;
	
	private JDBCTemplate() {
		
	}
	
	public static JDBCTemplate getInstance() {
		if(instance==null) {
			instance = new JDBCTemplate();
		}
		
		return instance;
	}
	
	//JDBCTamplate 인스턴스 싱글톤 패턴 적용
	
	public Connection createConnection() throws SQLException {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="MemberWeb";
		String password="MemberWeb";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		try {
			if(conn == null|| conn.isClosed()) {
				Class.forName(driver);
				conn=DriverManager.getConnection(url,user,password);
				conn.setAutoCommit(false);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return conn;
	
	
	}
	
	public  static void close() {
			try {
				if(conn!=null) {
				if(!conn.isClosed()) {
					conn.close();
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	
	public static void commit() {
		try {
			if(conn!=null) {
			if(!conn.isClosed()) {
				conn.commit();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public static void rollback() {
		try {
			if(conn!=null) {
			if(!conn.isClosed()) {
				conn.rollback();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	}



