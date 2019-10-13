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
	
	<link rel="stylesheet" type="text/css" href="css/studentStyle.css">
	
  </head>
  
  <body>
  	<div>
  		<img class="bg" src="image/bg.jpg">
		<div class ="containter">
			<div class="nameBox">
				<div>姓名:</div>
				<div class="name">张三</div>
			</div>
			<div class="box">
				<div>学号:</div>
				<div class="num">16665555777</div>
			</div>
			<div class="box">
				<div>选择方向:</div>
				<select>
				   	<c:forEach items="${['软件测试','移动开发','软件测试','移动开发']}" var="item" >
		   				<option value ="volvo">${item}</option>
		   			</c:forEach>
				</select>
			</div>
			<div class="detailBox">
				<div>查看方向详情:</div>
				<ul>
		   			<c:forEach items="${['软件测试','移动开发','软件测试','移动开发','软件测试','移动开发','软件测试','移动开发']}" var="item" >
		   				<li><a href="/work/detail.jsp">${item}</a></li>
		   			</c:forEach>
				</ul>
			</div>	
			<button>确认</button>
		</div>
  	</div>
  </body>
</html>
