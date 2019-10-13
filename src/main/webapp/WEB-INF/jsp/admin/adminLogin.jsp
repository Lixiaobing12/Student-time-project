<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/loginStyle.css">
	
  </head>
  
  <body>
    <div  id="loginPage">
		<img class="bg" src="${pageContext.request.contextPath}/resources/image/bg.jpg">
		<form action="${pageContext.request.contextPath}/admin/login"; method="post">
			<div id="loginBox">
				<div class="userBox">
					<div>账号：</div>
					<input type="text" name="number">
				</div>
				<div class="passWordBox">
					<div>密码：</div>
					<input type="password" name="password">
				</div>
				<button class="btn"  id="btn">登录</button>
			</div>
		</form>
	</div>
	<c:if test="${info == 0}">
		<script>
            alert("请填写正确的登录信息")
		</script>
	</c:if>
	<c:if test="${sessionScope.aInterInfo == 0}">
		<script>
            alert("你还没有登录，请先登录")
		</script>
	</c:if>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/login.js"></script>
  </body>
</html>
