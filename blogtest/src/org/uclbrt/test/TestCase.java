package org.uclbrt.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.entity.Daily;

public class TestCase {

	@Test
	public void testSave() {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println(session);
			DailyMapper mapper = session.getMapper(DailyMapper.class);
			List<Daily> list= mapper.getById(1);
			System.out.println(list);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}



	
	

}
