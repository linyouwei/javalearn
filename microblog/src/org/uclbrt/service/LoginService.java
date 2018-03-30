package org.uclbrt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.uclbrt.dao.UserLoginMapper;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.util.SystemConstant;

@Service
public class LoginService implements SystemConstant{
	@Resource
	private UserLoginMapper userLoginMapper;	
	@Resource
	public Map<String,Object> addUser(UserLogin user){
		//判斷是否有重名
		UserLogin user_name = userLoginMapper.findByName(user.getUsername());
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(user_name==null){
			//若數據庫沒有該數據，插入數據庫
			user.setPassword(user.getPassword());
			user.setUsername(user.getUsername());
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setCreate_time(d);
			user.setRole_id('3');
			userLoginMapper.save(user);
			//
			map.put("pass", true);
		}else{
			//若數據庫有該數據返回錯誤提示
			map.put("pass", false);
			
		}
		return map;
		
	}
	
	}
