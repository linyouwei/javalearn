/**
 * 页面初始化后，绑定函数。
 */
$(function(){
	//注册
	$("#sign-up").click(function(){
		register();
	});
});
//注册
function register() { 
	var user_nickname = $("#user_nickname").val();
	var user_password = $("#user_password").val();
	$.post('/microblog/myblog/register.form', {
	    'user_nickname': user_nickname,
	    'user_password': user_password
		}, function (data) {
			console.log(data);

})}

