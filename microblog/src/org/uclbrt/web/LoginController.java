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
@RequestMapping("/WebUser")
public class LoginController implements SystemConstant {
	@Resource
	private LoginService loginService;

	@RequestMapping("/register.form")
	@ResponseBody
	public Result toRegister(UserLogin user) {
		if (user == null) {
			throw new RuntimeException("参数为空");
		}
		Map<String, Object> map = loginService.addUser(user);
		return new Result(map);
	}

	@RequestMapping(value = "/Login.form", method = RequestMethod.GET)
	public String login() {
		return "../jsp/user/login";
	}

	@RequestMapping("/checklogin.form")
	@ResponseBody
	public Result toLogin(String username, String password, HttpSession session) {
		Map<String, Object> map = loginService.checkLogin(username, password);
		Object status = map.get("status");
		if (status.equals(SUCCESS)) {
			session.setAttribute("user", map.get("user"));
		}
		return new Result(map);
	}

}
