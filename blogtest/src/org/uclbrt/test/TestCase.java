package org.uclbrt.test;



import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.uclbrt.dao.CommentMapper;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.dao.UserDetailMapper;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.UserDetail;

public class TestCase {
//
//	@Test
//	public void testSave() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			DailyMapper mapper = session.getMapper(DailyMapper.class);
//			List<Daily> list= mapper.getById(1);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).getUserinfo().getUserName());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
	@Test
	public void testDao() {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			UserDetailMapper mapper = session.getMapper(UserDetailMapper.class);
			UserDetail list = mapper.findDetailByUserId(1);
			System.out.println(123);
			System.out.println(list.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
/*	@Test
	public void testSave() {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			UserLoginMapper mapper = session.getMapper(UserLoginMapper.class);
			UserLogin d= mapper.findByName("www");
			System.out.println(d.getUserName()+d.getCreatedTime());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}*/
	



	
	

}
