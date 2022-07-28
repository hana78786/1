package com.kh.memeber.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	private static JDBCTemplate instance;
	private static Connection conn;
	private Properties prop = new Properties();

	private JDBCTemplate() {

	}

	public static JDBCTemplate getInstance() {
		if (instance == null) {
			instance = new JDBCTemplate();

		}
		return instance;
	}

	public Connection createConnection() throws SQLException, ClassNotFoundException {
	//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//	String user = "student";
	//	String password = "student";
		
		try {
			FileReader fReader = new FileReader("resources/driver.properties");
			prop.load(fReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = prop.getProperty("driver");
		String url= prop.getProperty("url");
		String user= prop.getProperty("user");
		String password= prop.getProperty("password");
		
		if(conn==null||conn.isClosed()) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,password);
			conn.setAutoCommit(false);
		}
		
		return conn;
	}
	
	
	public void close() {
		
		if(conn!=null) {
				try {
					if(!conn.isClosed()) {
					conn.close();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
	public void close(Statement stmt, ResultSet rset) {
		if(rset!=null) {
			try {
				if(!rset.isClosed()) {
				rset.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		if(stmt!=null) {//prepaerdStatement는 Statement를 상속해서 만들었기 때문에
			try {
				if(!stmt.isClosed()) {//Statement로다 닫을수있다.
				stmt.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
	}
	}
	
	
	
	public void rollback(){
		
	}
	
	

}
