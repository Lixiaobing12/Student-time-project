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
	
	<link rel="stylesheet" type="text/css" href="css/adminStyle.css">
	
  </head>
  
  <body>
    <div>
		<img class="bg" src="image/bg.jpg">
		<div class="box">
			<div class="title">管理员操作界面</div>
			<div class="containter">
				<div><a href="/work/course.jsp">添加课程</a><a href="/work/delectCourse.jsp" class="delect">删除课程</a></div>
				<div><a href="/work/teacher.jsp">添加老师</a><a href="/work/delectTeacher.jsp" class="delect">删除老师</a></div>
				<div><a href="/work/direction.jsp">添加方向</a><a href="/work/delectDirection.jsp" class="delect">删除方向</a></div>
			</div>
		</div>
	</div>
  </body>
</html>
