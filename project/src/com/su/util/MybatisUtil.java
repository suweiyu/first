package com.su.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.jdbc.Connection;

public class MybatisUtil {
	static SqlSessionFactory factory=null;
	static {
		String resource = "configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	
		public static SqlSession getSqlSession() {
			return factory.openSession();
		}
		
}
