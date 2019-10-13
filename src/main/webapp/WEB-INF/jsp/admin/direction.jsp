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

	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/directionStyle.css">
	  <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	
  </head>
  
  <body>
    <%--<div>--%>
		<%--<img class="bg" src="image/bg.jpg">--%>
        <%--<form action="/admin/dir/add" method="post">--%>
		<%--<div class="box">--%>
			<%--<div class="title">添加方向关联课程</div>--%>
			<%--<div class="containter">--%>
		   		<%--<c:forEach items="${course}" var="item" >--%>
		   			<%--<div><input class="check" name="cid" type="checkbox" value="${item.id}" />${item.name}</div>--%>
		   		<%--</c:forEach>--%>
			<%--</div>--%>
			<%--<select name="majorId">--%>
				<%--<option value="2">天理</option>--%>
			<%--</select>--%>
			<%--&lt;%&ndash;<input class="input" type="text" name="start" placeholder="方向名称"/>&ndash;%&gt;--%>
			<%--&lt;%&ndash;<input class="input" type="text" name="end" placeholder="方向名称"/>&ndash;%&gt;--%>
			<%--<input class="input" type="text" name="name" placeholder="方向名称"/>--%>

			<%--<input type="submit" value="确认">--%>
		<%--</div>--%>
		<%--</form>--%>
	<%--</div>--%>

	<div>
		<form action="${pageContext.request.contextPath}/admin/dir/add" id="form">
		<img class="bg" src="${pageContext.request.contextPath}/resources/image/bg.jpg">
		<div class="box">
			<div class="title">添加方向关联课程</div>
			<div class="containter">
				<c:forEach items="${course}" var="item" >
					<div><input class="check" name="cid" type="checkbox" value="${item.id}" />${item.name}</div>
				</c:forEach>
			</div>
			<div>
				<select name="majorId">
					<c:forEach items="${major}" var="item" >
						<option value ="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
				<input class="input" type="text" name="name" placeholder="添加方向"/>
				<input class="input" type="text" name="number" placeholder="人数限制"/>
			</div>
			<div class="time">
				<div>开始时间<input type="text" id="start" name="start" onclick="WdatePicker()"/></div>
				<div>结束时间<input type="text" id="end" name="end" onclick="WdatePicker()"/></div>
			</div>
			<textarea rows="" cols="" name="intro" placeholder="方向介绍"></textarea>
			<textarea rows="" cols="" name="target" placeholder="培养目标"></textarea>
			<button onclick="document.getElementById('form').submit()">确认</button>
		</form>
		</div>
	</div>
  </body>
</html>
