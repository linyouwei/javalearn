package org.uclbrt.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.HomePageService;
import org.uclbrt.util.EmptyUtil;
import org.uclbrt.util.SystemConstant;

/**
 * 用户登录,注册等功能
 *
 * @author YouWei Lin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/homePage")
public class HomePageController implements SystemConstant {
	@Resource
	private HomePageService homePageService;

	@RequestMapping(value ="/index.form", method = RequestMethod.GET)
	public String index(ModelMap map,HttpSession session) {
		System.out.println(123);
		UserLogin user = (UserLogin) session.getAttribute("user");
		System.out.println(user);
		if(!EmptyUtil.isNullOrEmpty(user)){
			System.out.println(222);
			//查询该用户的博客列表
			List<Daily> dailyList = homePageService.getDaily(user.getId());
			//查询该用户的最新博客
			List<Daily> recentDailyList = homePageService.findUserRecentDaily(user.getId());
			//查询该用户的归档
			List<Map> archivesList = homePageService.getUserArchivesDate(user.getId());
			//查询用户自定义分类列表
			List<Map> userCategoryList = homePageService.getUserCategoryList(user.getId());
	
			
			map.put("dailyList",dailyList);	
			map.put("recentDailyList",recentDailyList);	
			map.put("archivesList",archivesList);	
			map.put("userCategoryList",userCategoryList);	
			return "../jsp/index/index";	
		}else{
			System.out.println('1');
			//查询所有博客列表
			List<Daily> dailyList = homePageService.getAllDaily();
			//查询最新博客（整个系统的）
			List<Daily> recentDailyList = homePageService.findRecentDaily();
			//查询整个系统的分类
			List<Map> categoryList = homePageService.getCategoryList();
			System.out.println('2');
			map.put("dailyList",dailyList);	
			map.put("recentDailyList",recentDailyList);	
			map.put("categoryList",categoryList);	
			return "../jsp/index/index";	
		}		
	}
	@RequestMapping(value ="/dailyDetail.form", method = RequestMethod.GET)
	public String daily(int dailyId,ModelMap map,HttpSession session) {
		System.out.println(123);
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//获取daily
			//获取评论
			
			
		}
		
		return "../jsp/index/index";	
	}

	
	

}
