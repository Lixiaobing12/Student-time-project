<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/major.css">

</head>

<body>
<div>
    <img class="bg" src="${pageContext.request.contextPath}/resources/image/bg.jpg">
    <form action="${pageContext.request.contextPath}/admin/major/add">
        <div class="box">
            <div class="title">添加专业</div>
            <div class="containter">
                <input class="input" type="text" name="name" placeholder="专业名称"/>
                <input class="input" type="text" name="pastern" placeholder="系部名称"/>
            </div>
            <input class="btn" type="submit" value="确认">
        </div>
    </form>
</div>
</body>
</html>
