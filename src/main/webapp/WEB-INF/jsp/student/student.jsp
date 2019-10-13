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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/studentStyle.css">
	
  </head>
  
  <body>
  	<div>
  		<img class="bg" src="${pageContext.request.contextPath}/resources/image/bg.jpg">

		<form action="${pageContext.request.contextPath}/student/pick" method="post">
			<div class ="containter">
				<div class="nameBox">
					<div>姓名:</div>
					<div class="name">${sessionScope.student.name}</div>
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <a href="${pageContext.request.contextPath}/student/remove">注销</a>
					&nbsp; &nbsp; &nbsp; &nbsp;
                    <a href="${pageContext.request.contextPath}/student/toUpdate">修改密码</a>
				</div>
				<div class="box">
					<div>学号:</div>
					<div class="num">${sessionScope.student.number}</div>
				</div>
				<div class="box">
					<div>选择方向:</div>
					<select name="dirId">
						<c:forEach items="${directions}" var="item" >
							<option value =${item.id}>${item.name}</option>
						</c:forEach>
					</select>
					<c:if test="${sessionScope.student.direction == null}">
						你还没选择方向
					</c:if>
					<c:forEach items="${directions}" var="item">
						<c:if test="${item.id == sessionScope.student.direction}">
                            &nbsp;&nbsp;&nbsp;&nbsp;
							已选方向:${item.name}
						</c:if>
					</c:forEach>
				</div>
				<div class="detailBox">
					<div>查看方向详情:</div>
					<ul>
						<c:forEach items="${directions}" var="item" >
							<li><a href="${pageContext.request.contextPath}/student/detail/${item.id}">${item.name}</a></li>
						</c:forEach>
					</ul>
				</div>
				<button type="submit"> 确认</button>
			</div>
		</form>
  	</div>
  </body>

  <c:if test="${sessionScope.pickInfo == 0}">
	  <script>
          alert("该方向人数已满，请重选择")
	  </script>
  </c:if>

  <c:if test="${sessionScope.pickInfo == 1}">
	  <script>
          alert("选择成功")
	  </script>
  </c:if>
</html>
