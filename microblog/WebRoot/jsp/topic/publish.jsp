
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String ctxPath = request.getContextPath();  
    request.setAttribute("ctxPath", ctxPath);  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()  
            + ctxPath + "/";  
    request.setAttribute("basePath", basePath);  
%>  
<!doctype html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
    <link rel="stylesheet" href="${ctx}/scripts/common/kindeditor/themes/default/default.css"/>
    <script charset="utf-8" src="${ctx}/scripts/common/kindeditor/kindeditor-min.js"></script>
    <script charset="utf-8" src="${ctx}/scripts/common/kindeditor/lang/zh_CN.js"></script>
	<link rel="stylesheet href="${ctx}/styles/setting.css"/>
</head>

<body id="blog">
<br><%@ include file="../common/top.jsp" %>

<div class="am-g am-g-fixed" id="dataListDiv">
    <div class="am-u-md-3 am-u-sm-12">
        <div class="am-g am-g-fixed">
            <ul class="am-nav">
                <li id="basic-set"><a href="#">文章管理</a></li>
                <li id="user-data"><a href="#">专栏管理</a></li>
                <li id="comment-manage"><a href="#">评论管理</a></li>
                <li id="category-manage"><a href="#">个人分类管理</a></li>
            </ul>
        </div>
    </div>
    <div class="am-u-md-9 am-u-sm-12" id="user-list">
        <div style="display: inline-block">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li ><a href="#">全部</a></li>
            <li ><a href="#">已发表</a></li>
            <li ><a href="#">草稿箱</a></li>
            <li ><a href="#">回收站</a></li>
        </ul>
            </div>
        <div ><a href="{% url 'myblog:publishEdit' %}" style="padding: 100px;"><button >写博客</button></a>
            </div>
    </div>
</div>
<div class="am-g am-g-fixed blog-fixed" id="search">
    <div class="am-u-md-8 am-u-sm-12" id="search_data">
    </div>
</div>


<footer class="blog-footer"></footer>


<script>
    //简单模式初始化
    var editor;
    KindEditor.ready(function (K) {
        editor = K.create('textarea[name="content"]', {
            resizeType: 1,
            allowPreviewEmoticons: false,
            allowImageUpload: false,
            items: [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'emoticons', 'image', 'link']
        });
    });
</script>
</body>
</html>