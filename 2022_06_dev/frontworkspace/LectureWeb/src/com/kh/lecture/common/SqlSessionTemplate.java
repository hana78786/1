package com.kh.lecture.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		SqlSession session=null;
		String resource="mybatis-config.xml";
		//연결공장 빌드
		try {
			//XML파일 읽기
			InputStream is = Resources.getResourceAsStream(resource);
			//연결공장 빌더
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 연결공장
			SqlSessionFactory factory = builder.build(is);
			//연결객체 생성
			session = factory.openSession();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return session;
				
	}

}
