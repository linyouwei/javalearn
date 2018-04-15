

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.uclbrt.entity.*" %>
<%@page import="org.apache.taglibs.standard.tag.common.core.ChooseTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Blog </title>
    <script src="/static/jquery/2.1.3/jquery.min.js"></script>
    <script src="/static/assets/js/amazeui.min.js"></script>
    <link rel="stylesheet" href="/static/assets/css/amazeui.min.css"/>
    <style>
        @media only screen and (min-width: 1200px) {
            .blog-g-fixed {
                max-width: 1200px;
            }
        }

        @media only screen and (min-width: 641px) {
            .blog-sidebar {
                font-size: 1.4rem;
            }
        }

        .blog-main {
            padding: 20px 0;
        }

        .blog-title {
            margin: 10px 0 20px 0;
        }

        .blog-meta {
            font-size: 14px;
            margin: 10px 0 20px 0;
            color: #222;
        }

        .blog-meta a {
            color: #27ae60;
        }

        .blog-pagination a {
            font-size: 1.4rem;
        }

        .blog-team li {
            padding: 4px;
        }

        .blog-team img {
            margin-bottom: 0;
        }

        .blog-content img,
        .blog-team img {
            max-width: 100%;
            height: auto;
        }

        .blog-footer {
            padding: 10px 0;
            text-align: center;
        }
    </style>
</head>
<body>
<header class="am-topbar">
    <h1 class="am-topbar-brand">
        <a class="am-active" href="{% url 'myblog:index' %}">微书</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li class="am-active"><a href="#">发现</a></li>
            <li class="am-active"><a href="#">关注</a></li>
            <li class="am-active"><a href="#">消息</a></li>
        </ul>

        <form method="get" action="{% url 'myblog:searchDaily' %}" class="am-topbar-form am-topbar-left am-form-inline"
              role="search">
            <div class="am-form-group">
                <input type="text" class="am-form-field am-input-sm" id="search-data" name="searchVal">
                <input type="submit" class="search-btn" id="search-btn" value="搜索">
                <input type="hidden" name="type" value="note">
            </div>
        </form>

           <div class="am-topbar-right">
        	<% UserLogin user=(UserLogin)session.getAttribute("user"); 
        	boolean loginFlag ;
        	if(user!=null) loginFlag = true;   
        	else loginFlag = false; 
        	%> 
        	<c:choose>   
	        	<c:when test="<%=loginFlag%>">	
		            <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
		                <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
		                        data-am-dropdown-toggle> ${user.userName}  <span class="am-icon-caret-down"></span></button>
		                <ul class="am-dropdown-content">
		                    <li><a href="{% url 'myblog:publish' %}">发布</a></li>
		                    <li><a href="{% url 'myblog:setting_basic' %}">设置</a></li>
		                    <li><a href="{% url 'myblog:sign_out' %}">退出</a></li>
		                </ul>
		            </div>
	            </c:when>
	            <c:otherwise>
		            <div class="am-topbar-right">
		                <a href="/myblog/register" class="am-btn am-btn-primary am-topbar-btn am-btn-sm color">注册</a>
		            </div>
		            <div class="am-topbar-right">
		                <a href="/myblog/login" class="am-btn am-btn-primary am-topbar-btn am-btn-sm">登录</a>
		            </div>
	            </c:otherwise>
           </c:choose>
        </div>
    </div>
</header>

<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8">
        <article class="blog-main">
            <h3 class="am-article-title blog-title">
                <a href="#">${daily.title }</a>
            </h3>
            <h4 class="am-article-meta blog-meta">by <a href="">${daily.userInfo.userName }</a> post
                on ${daily.createdTime } </h4>
            <div class="am-g blog-content">
                <div class="am-u-lg-7">
                </div>
                <p>${ daily.body }</p>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                </div>
            </div>
        </article>
        <hr class="am-article-divider blog-hr">
        <hr class="am-article-divider blog-hr">
        <ul class="am-pagination blog-pagination">
            <li class="am-pagination-prev"><a href="/myblog/daily/?dailyid={{ daily.id | add:-1}}">&laquo; 上一页</a></li>
            <li class="am-pagination-next"><a href="/myblog/daily/?dailyid={{ daily.id | add:1}}">下一页 &raquo;</a></li>
        </ul>
    </div>
</div>
<c:choose>
	<c:when test="<%=loginFlag%>">
	<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8">
        <form class="am-form">
            <fieldset>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">姓名</label>
                    <input type="text" disabled value="<%=user.getUserName() %>">
                </div>
                <div class="am-form-group">
                    <label for="doc-ta-1">评论</label>
                    <textarea class="text" rows="5" id="comment-content" value=""></textarea>
                    <input type="hidden" value="${daily.id}" name='dailyId' id="dailyId">
                </div>
                <input type="button" class="am-btn am-btn-primary" id="btn-submit" value="发表">
            </fieldset>
        </form>
    </div>
</div>
	</c:when>
	<c:otherwise>
		<div class="am-g am-g-fixed blog-g-fixed">
	    <div class="am-u-md-8">
	       	 注册用户登录后才能发表评论，请
		        <a href="/myblog/login">登录</a>
		        <a href="/myblog/register">注册</a>
		        <a href="/myblog/index">访问</a>网站首页
	    </div>
		</div>
	</c:otherwise>
</c:choose>

<% 
       List<Comment> commentList = (List<Comment>)request.getAttribute("commentList");
       boolean commentFlag;
       if(commentList==null || commentList.size()==0) commentFlag = false;
       else commentFlag = true;
%>
<%--评论列表 --%>
<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8">
        <ul class="am-comments-list" id="ul-list">
			<c:choose>
				<c:when test="<%=commentFlag%>">
					<c:forEach items="${requestScope.commentList}" var="u">
			 			<li class="am-comment">
			                <article class="am-comment"> <!-- 评论容器 -->
			                    <a href="">
			                        <img class="am-comment-avatar"
			                             src="http://www.gravatar.com/avatar/1ecedeede84abbf371b9d8d656bb4265?d=mm&s=96"
			                             alt=""/>
			                        <!-- 评论者头像 -->
			                    </a>
			                    <div class="am-comment-main"> <!-- 评论内容容器 -->
			                        <header class="am-comment-hd">
			                            <!--<h3 class="am-comment-title">评论标题</h3>-->
			                            <div class="am-comment-meta"> <!-- 评论元数据 -->
			                                <a href="#link-to-user" class="am-comment-author">${u.userInfo }</a>
			                                <!-- 评论者 -->
			                                		评论于
			                                <time datetime="">${u.createdTime }</time>
			                            </div>
			                        </header>
			                        <div class="am-comment-bd">${u.content }</div> <!-- 评论内容 -->
			                    </div>
			                </article>
			            </li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>暂无评论</p>
				</c:otherwise>
			</c:choose>
        </ul>
    </div>
</div>




<div id="comment-template">
<li class="am-comment">
                <article class="am-comment"> <!-- 评论容器 -->
                    <a href="">
                        <img class="am-comment-avatar"
                             src="http://www.gravatar.com/avatar/1ecedeede84abbf371b9d8d656bb4265?d=mm&s=96"
                             alt=""/>
                        <!-- 评论者头像 -->
                    </a>
                    <div class="am-comment-main"> <!-- 评论内容容器 -->
                        <header class="am-comment-hd">
                            <!--<h3 class="am-comment-title">评论标题</h3>-->
                            <div class="am-comment-meta"> <!-- 评论元数据 -->
                                <a href="#link-to-user" class="am-comment-author">{{ comment.name }}</a>
                                <!-- 评论者 -->
                                评论于
                                <time datetime="">{{ comment.create_time|date:"Y-m-d H:i:s" }}</time>
                            </div>
                        </header>
                        <div class="am-comment-bd">{{ comment.content }}</div> <!-- 评论内容 -->
                    </div>
                </article>
            </li>
    </div>
</footer>
<script>
    $(function () {
        $("#comment-template").hide();
        $("#btn-submit").click(function () {
            $.post('/myblog/comment/', {
                    'dailyid': $("#dailyid").val(),
                    'content': $("#comment-content").val()
                }, function (data) {
//                console.log(data);
                   setCommentList(data);
                }
            )
        })
        function setCommentList(data) {
            var row = $($("#comment-template").clone().html());
             row.find("header div a").text(data.user_name);
            row.find("header div time").text(data.create_time);
           row.find("div header").siblings().text(data.content)
            row.appendTo("#ul-list");
        }
    })
</script>

</body>
</html>
