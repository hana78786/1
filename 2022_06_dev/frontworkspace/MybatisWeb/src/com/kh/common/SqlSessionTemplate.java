package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSeesion() {
		SqlSession session = null;
		String resource="mybatis-config.xml";	
		
		
		try {
			//resource 경로 inputStream객체 생성
			InputStream is = Resources.getResourceAsStream(resource);
			//builder객체 생성
			SqlSessionFactoryBuilder bulder =new SqlSessionFactoryBuilder();
			//factory객체 생성 후
			SqlSessionFactory factory = bulder.build(is);
			//session 생성(연결 생성)
			session= factory.openSession();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

}
