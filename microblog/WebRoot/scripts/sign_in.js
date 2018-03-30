 $(function () {
        $("#user_nickname").blur(function () {
            var patrn = /^[a-zA-Z]([a-zA-Z0-9]|[._]){2,19}$/;
            var username = $("#user_nickname").val();
            if (!patrn.test(username)) {
                layer.tips('只能输入3-20个以字母开头、可带数字、“_”、“.”的字串', '#user_nickname');
                return false;
            }
            $.post('/myblog/sign_up_ajax_check/', {
                'username': username
            }, function (data) {
                //1为存在用户，0为不存在用户
                if (data.msg === '1') {
                    layer.tips('您输入的用户名存在！请重新输入！', '#user_nickname');
                }
            })
        })
        $("#username").focus(function () {
            $('#name_msg').empty()
        })

        $("#sign-up").click(function () {
            var user_nickname = $("#user_nickname").val();
            var user_password = $("#user_password").val();
            $.post('/myblog/sign_up/', {
                'user_nickname': user_nickname,
                'user_password': user_password
            }, function (data) {
                console.log(data.msg);
                if (data.msg === '301') {
                    layer.tips('只能输入3-20个以字母开头、可带数字、“_”、“.”的字串', '#user_nickname');
                } else if (data.msg == '302') {
                    layer.tips('只能输入6-16位', '#user_password');
                } else if (data.msg === '303') {
                    layer.tips('您输入的用户名存在！请重新输入！', '#user_nickname');
                } else {

                }
            })

        })
    })