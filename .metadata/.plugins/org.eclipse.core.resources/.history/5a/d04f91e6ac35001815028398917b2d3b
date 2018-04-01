package org.uclbrt.test;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.uclbrt.dao.UserLoginMapper;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.LoginService;

public class TestCase {

//	@Test
//	public void testFindByName(){
//		String conf = "applicationContext.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		UserLoginMapper mapper = ac.getBean("userLoginMapper",UserLoginMapper.class);
//		UserLogin user = mapper.findByName("www");
//		System.out.println(user.getUsername()+","+user.getPassword());
//	}
	@Test
	public void testSave(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserLoginMapper mapper = ac.getBean("userLoginMapper",UserLoginMapper.class);
		UserLogin user = new UserLogin();
		user.setUsername("lin");
		user.setPassword("222");
		user.setCreate_time(new Date());
		user.setRole_id(3);
		mapper.save(user);
	}
//	}
//	//測試LoginService 中的addUser()方法
//	@Test
//	public void testAddUser(){
//		int i = 1;
//		String conf = "applicationContext.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		System.out.println(i=i+1);
//		LoginService ser = ac.getBean("loginService",LoginService.class);
//		User user = new User();
//		user.setCn_user_token(null);
//		user.setCn_user_name("machao");
//		user.setCn_user_desc("馬超");
//		user.setCn_user_password("123456");
//		ser.addUser(user);
//	}

	
	

}
