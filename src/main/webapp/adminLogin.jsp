<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
	
  </head>
  
  <body>
    <div  id="loginPage">
		<img class="bg" src="image/bg.jpg">
		<div id="loginBox">
			<div class="userBox">
				<div>账号：</div>
				<input type="text" name="user">
			</div>
			<div class="passWordBox">
				<div>密码：</div>
				<input type="password" name="user">
			</div>
			<div class="textBox">
				<div>管理员登录</div>
			</div>
			<button class="btn"  id="btn">登录</button>
		</div>
	</div>
	<script type="text/javascript" src="js/login.js"></script>
  </body>
</html>
