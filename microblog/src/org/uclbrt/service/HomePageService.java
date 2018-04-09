package org.uclbrt.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.entity.Daily;
import org.uclbrt.util.Md5Util;
import org.uclbrt.util.SystemConstant;

@Service
public class HomePageService implements SystemConstant {
	@Resource
	private DailyMapper dailyMapper;

	public List<Daily> getDaily(int userId) {
		
		// 判断用户名是否存在
		List<Daily> dailyList=new ArrayList<Daily>();
		List<Daily> d=  dailyMapper.findAllDaily(userId);
		System.out.println(d);
		return  d;
	}
}
