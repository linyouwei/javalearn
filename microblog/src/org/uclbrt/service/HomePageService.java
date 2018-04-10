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
		List<Daily> list=  dailyMapper.getById(userId);
		for(int i=0;i<list.size();i++){
		}
		return  list;
	}
	public List<Daily> getAllDaily() {
		// 判断用户名是否存在
		List<Daily> list=  dailyMapper.findAllDaily();
		return  list;
	}
	public List<Daily> findRecentDaily() {
		// 判断用户名是否存在
		List<Daily> list=  dailyMapper.findRecentDaily();
		return  list;
	}
	public List<Daily> findUserRecentDaily(int id ) {
		// 判断用户名是否存在
		List<Daily> list=  dailyMapper.findUserRecentDaily(id);
		return  list;
	}
	public List<Map> getUserArchivesDate(int id ) {
		// 判断用户名是否存在
		HashMap<String,String> map = new HashMap<String,String>();
		List<Map> list=  dailyMapper.getUserArchivesDate(id);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return  list;
	}
	public List<Map> getUserCategoryList(int id ) {
		// 判断用户名是否存在
		HashMap<String,String> map = new HashMap<String,String>();
		List<Map> list=  dailyMapper.getUserCategoryList(id);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return  list;
	}
}
