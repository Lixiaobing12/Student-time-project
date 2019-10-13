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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/delectCourseStyle.css">
	
  </head>
  
  <body>
    <div>
		<img class="bg" src="${pageContext.request.contextPath}/image/bg.jpg">
		<div class="box">
			<div class="title">删除专业</div>
			<form action="${pageContext.request.contextPath}/admin/major/del">
			<div class="containter">
				<select name="id">
					<c:forEach var="t" items="${result}">
						<option value="${t.id}">${t.name}</option>
					</c:forEach>
				</select>
				<input type="submit" class="delect" value="删除"/>
			</div>

			</form>
			<button class="btn"  onclick="window.location.href='${pageContext.request.contextPath}/admin/admin'">返回</button>
		</div>
	</div>
  </body>
</html>
