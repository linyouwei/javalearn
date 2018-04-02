<! DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/microblog/scripts/common/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="/microblog/styles/login.css" />

<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
<body>
<div class="sign" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/microblog/WebRoot/jsp/user/login.jsp">
    <div class="header">
        <div class="am-g">
            <h1>Simple Blog</h1>
        </div>
        <hr/>
    </div>
    <div class="main">
        <h4 class="title">
            <div class="normal-title">
                <a class="active" href="/microblog/sign/login.html">登录</a>
                <b>·</b>
                <a id="js-sign-up-btn" href="/microblog/sign/register.html">注册</a>
            </div>
        </h4>
        <form action="" method="post" class="am-form">
            <fieldset class="am-form-set">
                <div class="input-prepend restyle">
                    <input placeholder="你的昵称" type="text" value="" name="username" id="username">
                    <i class="am-icon-user"></i>
                </div>
                <div class="input-prepend restyle">
                    <input placeholder="密码" type="text" value="" name="password" id="password">
                    <i class="am-icon-user"></i>
                </div>
                <div class="remember-btn">
                    <input type="checkbox"  value="true" checked="checked" name="session[remember_me]"
                           id="session_remember_me"><span>记住我</span>
                </div>
            </fieldset>
            <div>
                <input id="sign-in"  name="commit" value="登录" class="sign-up-button" data-disable-with="登录">
            </div>
        </form>
    </div>
</div>
</body>
<!-- 框架JS -->
<script src="/microblog/scripts/common/assets/js/jquery.min.js"></script>
<script src="/microblog/scripts/common/assets/js/amazeui.min.js"></script>
<script src="/microblog/scripts/common/layer/layer.js"></script>
<!-- 页面事件处理JS -->
<script type="text/javascript" src="/microblog/scripts/login.js"></script>
</html>
