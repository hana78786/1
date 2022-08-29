package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplat {

	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		
		InputStream is;
		try {
			
			
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder bulder= new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = bulder.build(is);
			session=factory.openSession();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
		
		
	}

}
