/**
 * 页面初始化后，绑定函数。
 */
$(function(){
	//注册
	$("#regist_button").click(function(){
		register();
	});
	
	//登录
	$("#login").click(function(){
		login();
	});
	
	//登出
	$("#logout").click(function(){
		logout();
	});
	
	//修改密码
	$("#changePassword").click(function(){
		changepwd();
	})
	
});

//注册
function register() {
	//浏览器的打印信息
	//console.log("into register")
//	alert("注册成功.");
//	$("#zc").attr("class","sig sig_out");
//	$("#dl").attr("class","log log_in");
	var user_name= $("#regist_username").val();
	var nick_name = $("#nickname").val();
	var password = $("#regist_password").val();
	var password2 = $("#final_password").val();
//	alert(user_name);
//	alert(nick_name);
//	alert(password);
//	alert(password2);
	//4、发送个数据库
	var flag = true;
	if(flag){
		$.post("/Spring_Mybatis_Merge/login/register.form",
		{"cn_user_name":user_name,"cn_user_password":password,"cn_user_desc":nick_name},
		function(result){
//			alert("进入result语句");
			if(result.success){
				var map = result.data;
				if(map.pass){
					alert("注册成功");
					$("#back").trigger("click");
				}else{
					alert("注册失败");
				}
			}else{
//				alert("result.success为true");
			}
		});
	}
}

//登陆
function login() {
	//验证用户名、密码不能为空
	var user_name = $("#count").val();
	var password = $("#password").val();
	console.log(user_name);
	console.log(password);
	console.log("进入login");
	if(user_name==null&password==null){	
		console.log("进入判断用户名、密码是否为空语句")
		return ;
	}else{
		console.log("用户名,密码不为空")
	}
	var reg = /^\w{3,20}$/;
	if(!reg.test(user_name)) {
		alert("用户名必须是3-20位字母、数字、下划线的组合");
		return;
	}
	$.post(
		"/cloudnote/login/checklogin.form",
		{"username":user_name,"password":password},
		function(result){
			var map = result.data;
			if(result.success){
				if(map.flag==0){
					//将用户信息存入cookie
					addCookie("user_id",map.user.cn_user_id,12);
					addCookie("user_name",map.user.cn_user_name,12);
					location.href="edit.html";
				}else if(map.flag==1){
					alert("用户名不正确");
				}else if(map.flag==2){
					alert("密码错误");
				}
			}else{
				alert(result.message);
			}
		}
		);
	
	
}

/**
 * 退出登录
 */
function logout(){
	console.log("进入logout方法")
	alert("进入logout方法")
	$.post("/cloudnote/login/removeSession.form",
		{},
		function(result){
			console.log(result.success);
			if(result.success){
				console.log("进入跳转页面");
				//获得cookie并删除，
				delCookie("user_name")
				
				$(".profile-username").text("");
				location.href="login.html"	
			}
			
		}
		)
	
}

/**
 * 修改密码
 */
function changepwd(){
	//检验密码格式
	var old_password = $("#last_password").val();
	var new_password1 = $("#new_password").val();
	var new_password2 = $("#final_password").val();
	var user_name = getCookie("user_name");
	console.log(old_password);
	console.log(new_password1);
	console.log(new_password2);
	console.log(user_name);
	if(old_password.length<6){
		
		$("#warning_1 span").text("密码长度小于六位");
		$("#warning_1").show();
		return;
	}else{
		$("#warning_1").hide();
	}
	if(new_password1.length>6){
		$("#warning_2").hide();
		console.log("进入判断密码长度函数1");
	}else{
		$("#warning_2 span").text("新密码长度过短");
		$("#warning_2").show();
		console.log("进入判断密码长度函数2");
		return;
	}
	if(new_password1!=new_password2){
		console.log("判断出密码不一致")
		$("#warning_3 span").text("密码输入不一致");
		$("#warning_3").show();
		return;
	}else{
		console.log("判断出密码一致");
		$("#waring_3").hide();
	}
	$.post("/cloudnote/login/changepwd.form",
		{"newPwd":new_password1,"oldPwd":old_password,"username":user_name},
		function(result){
			console.log("进入回调函数")
			var map = result.data;
			console.log(map);
			if(result.success){
				console.log(result);
				if(map.flag==4){
					alert("修改成功")
					logout();
				}
				console.log(map.flag)
				if(map.flag==3){
					console.log("进入3");
					//$("#warning_1").text("原始密码错误1");
					//$("#warning_1 span").text("原始密码错误");
					$("#warning_1").text("原始密码错误").show();
					console.log("warn1")
					return;
				}
			}else{
				alert(result.message);
			}
		}

		)
	
}


