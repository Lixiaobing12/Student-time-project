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
	
	<link rel="stylesheet" type="text/css" href="css/detailStyle.css">
	
  </head>
  
  <body>
 		<div class="containter">
 			<div class="box">
 				<div class="title">老师简介</div>
 				<div class="mes">1老师简介老师简介老师简介老师简介老师简介老师简介老师简介11111111111111111111111111111111111111111111111111111111111111111111111111111111111</div>
 			</div>
 			<div class="box">
 				<div class="title">培养目标</div>
 				<div class="mes">1111111111111111111</div>
 			</div>
 			<div class="box">
 				<div class="title">方向介绍</div>
 				<div class="mes">1111111111111111111</div>
 			</div>
 			<div class="box">
 				<div class="title">课程简介</div>
 				<div class="mes">1111111111111111111</div>
 			</div>
 		</div>
  </body>
</html>
