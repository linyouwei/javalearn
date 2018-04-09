package org.uclbrt.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.HomePageService;
import org.uclbrt.service.LoginService;
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
	public String index(ModelMap map) {
		//查询博客列表
		
		List<Daily> dailyList = homePageService.getDaily(1);
		System.out.println(dailyList);
		map.put("dailyList",dailyList);
		
		return "../jsp/index/index";
	}

	
	

}
