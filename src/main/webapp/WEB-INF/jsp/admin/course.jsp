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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courseStyle.css">
	
  </head>
  
  <body>
    <div>
		<img class="bg" src="image/bg.jpg">
		<div class="box">
			<div class="title">添加课程</div>
			<form action="${pageContext.request.contextPath}/admin/course/add">
			<div class="containter">
		   		<input type="text" name="name" placeholder="课程名称">
		   		<select name="tId">
					<c:forEach var="t" items="${teacher.data}">
						<option value="${t.id}">${t.name}</option>
					</c:forEach>
				</select>
			</div>
			<textarea rows="" cols="" placeholder="课程简介"  name="intro"></textarea>
			<input class="btn" type="submit" value="确认">
			</form>
		</div>
	</div>
  </body>
</html>
