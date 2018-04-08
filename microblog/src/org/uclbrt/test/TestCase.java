package org.uclbrt.test;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.dao.UserLoginMapper;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.LoginService;

public class TestCase {

	@Test
	public void testSave(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserLoginMapper mapper = ac.getBean("userLoginMapper",UserLoginMapper.class);
		UserLogin user = new UserLogin();
		user.setId(333);
		user.setUsername("gg");
		user.setPassword("ggggg");
		user.setCreate_time(new Date());
		user.setRole_id(3);
		mapper.save(user);
		mapper.commit();
	}
//	@Test
//	public void testGet(){
//		String conf = "applicationContext.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		DailyMapper mapper = ac.getBean("DailyMapper",DailyMapper.class);
//		System.out.println(mapper);
//		
//	}
	
	


	
	

}
