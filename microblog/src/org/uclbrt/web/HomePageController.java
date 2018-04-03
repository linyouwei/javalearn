package org.uclbrt.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uclbrt.entity.UserLogin;
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
	private LoginService loginService;

	@RequestMapping(value ="/index.form", method = RequestMethod.GET)
	public String index(UserLogin user, HttpSession session) {
		
		return "../jsp/index/index";
	}

}
