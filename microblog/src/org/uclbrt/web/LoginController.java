package org.uclbrt.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.LoginService;
import org.uclbrt.util.SystemConstant;

@Controller
@RequestMapping("/myblog")
public class LoginController implements SystemConstant {
	@Resource
	private LoginService loginService;
	@RequestMapping("/register.form")
	@ResponseBody
	public Result toRegister(UserLogin user){
		if(user==null){
			throw new RuntimeException("参数为空");
		}
		System.out.println("into register");
		Map<String,Object> map = loginService.addUser(user);
		System.out.println("out register");
		return new Result(map);
	}
	@RequestMapping("/checklogin.form")
	@ResponseBody
	public Result toLogin(String username,String password,HttpSession session){
		Map<String,Object> map = loginService.checkLogin(username,password);
		Object status = map.get("status");
		if(status.equals(SUCCESS)){
			session.setAttribute("user", map.get("user"));	
		}
		return new Result(map);
	}

}
