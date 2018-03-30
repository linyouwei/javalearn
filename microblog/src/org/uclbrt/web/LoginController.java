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
@RequestMapping("/sign_up")
public class LoginController implements SystemConstant {
	@Resource
	private LoginService loginService;
	@RequestMapping("/register.form")
	@ResponseBody
	public Result toRegister(UserLogin user){
		System.out.println("into register");
		Map<String,Object> map = loginService.addUser(user);
		System.out.println("out register");
		return new Result(map);
	}

}
