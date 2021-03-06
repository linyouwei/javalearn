package org.uclbrt.test;



import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.uclbrt.dao.CommentMapper;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.dao.UserDetailMapper;
import org.uclbrt.dao.UserLoginMapper;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.LoginService;

public class TestCase {

//	@Test
//	public void testSave(){
//		String conf = "applicationContext.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		UserLoginMapper mapper = ac.getBean("UserLoginMapper",UserLoginMapper.class);
//		UserLogin user = new UserLogin();
//		user.setId(123);
//		user.setUsername("gg");
//		user.setPassword("ggggg");
//		user.setCreate_time(new Date());
//		user.setRole_id(3);
//		mapper.save(user);
//	}
	/*@Test
	public void testGET(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DailyMapper mapper = ac.getBean("DailyMapper",DailyMapper.class);
		System.out.println(mapper);
		
	}*/
	
//	public void testAssociation() throws IOException{ 
//		//配置文件的名称  
//        String resource = "ssm/web.xml";  
//        //通过Mybatis包中的Resources对象很轻松的获取到配置文件  
//        Reader reader = Resources.getResourceAsReader(resource);  
//        //通过SqlSessionFactoryBuilder创建  
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//        //获得session实例  
//        SqlSession session =sqlSessionFactory.openSession();   
//	}
//	@Test
//	public void testDemo() {
//		List<Map> list = new ArrayList<Map>();
//		Map<Integer,String> map = new HashMap<Integer,String>();
//		map.put(1,"123");
//		list.add(map);
//		System.out.println(list);
//		
//	}
	@Test
	public void testDDD() {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			UserDetailMapper mapper = session.getMapper(UserDetailMapper.class);
			UserDetail list = mapper.findDetailByUserId(1);
//			System.out.println(123);
//			System.out.println(list.getProvince().getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
//	@Test
//	public void testDao1() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			DailyMapper mapper = session.getMapper(DailyMapper.class);
//			List<Daily> list = mapper.getDailyListByUserId(1);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).toString());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}




	
	

}
