

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.uclbrt.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ page language="java" import="java.util.*"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>BLOG</title>

    <link rel="stylesheet" href="/microblog/scripts/common/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="/microblog/scripts/common/assets/css/app.css">

</head>

<body id="blog">
<header class="am-topbar">
    <h1 class="am-topbar-brand">
        <a  class="am-active" href="#">微书</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li class="am-active"><a href="#">发现</a></li>
            <li  class="am-active"><a href="#">关注</a></li>
            <li  class="am-active"><a href="#">消息</a></li>
        </ul>

        <form method="get" action="{% url 'myblog:searchDaily' %}" class="am-topbar-form am-topbar-left am-form-inline" role="search">
            <div class="am-form-group">
                <input type="text" class="am-form-field am-input-sm"id="search-data" name="searchVal">
                <input type="submit" class="search-btn" id="search-btn" value="搜索">
                <input type="hidden" name="type" value="note">
            </div>
        </form>

        <div class="am-topbar-right">
        	<% UserLogin user=(UserLogin)session.getAttribute("user"); 
        	if(user!=null){%>
            <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
                <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
                        data-am-dropdown-toggle> ${user.userName}  <span class="am-icon-caret-down"></span></button>
                <ul class="am-dropdown-content">
                    <li><a href="{% url 'myblog:publish' %}">发布</a></li>
                    <li><a href="{% url 'myblog:setting_basic' %}">设置</a></li>
                    <li><a href="{% url 'myblog:sign_out' %}">退出</a></li>
                </ul>
            </div>
            <% }else{ %>
            <div class="am-topbar-right">
                <a href="/myblog/register" class="am-btn am-btn-primary am-topbar-btn am-btn-sm color">注册</a>
            </div>
            <div class="am-topbar-right">
                <a href="/myblog/login" class="am-btn am-btn-primary am-topbar-btn am-btn-sm">登录</a>
            </div>
           <%} %>
        </div>
    </div>
</header>
<div class="am-g am-g-fixed" id="dataListDiv">
    <div class="am-u-md-9 am-u-sm-12" id="myDailyList">
    	<%--
    	 List<Daily> list = (List<Daily>)request.getAttribute("dailyList");
    	 for(int i=0;i<list.size();i++){
    	 	out.println(list.get(i).getCreatedTime().getClass());
    	 }
    	--%>
    	
        <c:forEach items="${requestScope.dailyList}" var="u">
        <div class="am-u-lg-12 am-u-md-12 am-u-sm-12 ">
            <h1><a href="/myblog/daily/?dailyid={{ field.id }}">${u.title }</a></h1>
            <p>${u.body}</p>
            <%-- 
            <fmt:parseDate var="dateObj" value="${u.createdTime}" type="DATE" pattern="yyyy-MM-dd"/>
            <fmt:formatDate var="reTime" value='${dateObj}' pattern='yyyy-MM-dd' />
            --%>
            <%--<fmt:formatDate value="<%=new Date() %>" type="date" pattern="yyyy-MM-dd"/> --%>
            <p>${u.userinfo.userName} 发布于 ${u.createdTime}</p>
        </div>
        </c:forEach>
    </div>
    <div class="am-u-md-3 am-u-sm-12">
        <div class="am-g am-g-fixed">
            <h3 class="">最新文章</h3>
            <ul>
            	<% 
            	List<Daily> list = (List<Daily>)request.getAttribute("recentDailyList");
            	boolean flag;
            	if(list.size()!=0) flag = true;
            	else flag = false;
            	
            	%>
            	<c:choose>
            	<c:when test="<%=flag%>">
	                <c:forEach items="${requestScope.recentDailyList}" var="u">
	                <li>
	                    <a href="">${u.title }</a>
	                </li>
	                </c:forEach>        
                </c:when>
                <c:otherwise>
               		 <p>暂无文章！</p>
                </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="am-g am-g-fixed">
            <h3 class="">归档</h3>
            <ul>
                {% for daily in archives_list %}
                <li>
                    <a href="{% url 'myblog:archives' daily.year daily.month %}">{{ daily.year }}年{{ daily.month }}月</a> <span style="color:#0e90d2">{{daily.count}}篇</span>
                </li>
                {% empty %}
                暂无归档！
                {% endfor %}
            </ul>
        </div>
        <div class="am-g am-g-fixed">
            <h3 class="">分类</h3>
            <ul>
                {% for category in category_list %}
                <li>
                    <a href="{% url 'myblog:category' category.id %}">{{category.name}}</a>
                </li>
                {% empty %}
                暂无分类！
                {% endfor %}
            </ul>
        </div>
    </div>
</div>
<div class="am-g am-g-fixed blog-fixed" id="search">
    <div class="am-u-md-8 am-u-sm-12" id="search_data">
    </div>
</div>


<script type="text/html" id="js_template">
    <div class="am-u-lg-12 am-u-md-12 am-u-sm-12 blog-entry-text blog-text-center" id="div_search">
        <h1><a href=""> </a></h1>
        <p></p>
        <p></p>
    </div>
</script>



</script>
<!-- 框架JS -->
<script src="/microblog/scripts/common/assets/js/jquery.min.js"></script>
<script src="/microblog/scripts/common/assets/js/amazeui.min.js"></script>
<script src="/microblog/scripts/common/layer/layer.js"></script>
<!-- 页面事件处理JS -->
<!-- <script type="text/javascript" src="/microblog/scripts/login.js"></script>
 -->
 </body>
</html>