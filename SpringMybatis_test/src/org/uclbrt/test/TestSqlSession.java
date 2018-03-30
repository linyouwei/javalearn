package org.uclbrt.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.uclbrt.entity.UserLogin;

public class TestSqlSession {
	@Test
	public void testSqlSession() throws IOException{
		String conf = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		System.out.println(sf);
		SqlSession session = sf.openSession();
		System.out.println(session);
		UserLogin user = new UserLogin();
		user.setId(22);
		user.setUsername("lin");
		user.setPassword("222");
		user.setCreate_time(new Date());
		user.setRole_id(3);
		session.insert("save",user);
		session.commit();
		session.close();

		
		
	}

}
