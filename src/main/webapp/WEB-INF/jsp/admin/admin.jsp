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

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/adminStyle.css">

</head>

<body>
<div>
	<img class="bg" src="image/bg.jpg">
	<div class="box">
		<div class="title">管理员操作界面</div>
		<div class="containter">
			<div><a href="${pageContext.request.contextPath}/admin/course">添加课程</a><a href="${pageContext.request.contextPath}/admin/course/delPage" class="delect">管理课程</a></div>
			<div><a href="${pageContext.request.contextPath}/admin/teacher">添加老师</a><a href="${pageContext.request.contextPath}/admin/teacher/delPage" class="delect">管理老师</a></div>
			<div><a href="${pageContext.request.contextPath}/admin/dir">添加方向</a><a href="${pageContext.request.contextPath}/admin/dir/delPage" class="delect">管理方向</a></div>
			<div><a href="${pageContext.request.contextPath}/admin/major">添加专业</a><a href="${pageContext.request.contextPath}/admin/major/delPage" class="delect">管理专业</a></div>
			<div>
				<form action="${pageContext.request.contextPath}/student/importStudent" enctype="multipart/form-data" method="post">
					<input type="file" name="file">
					<button type="submit">确定</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
<c:if test="${info == 0}">
	<script>
		alert("请选择要导入的文件")
	</script>
</c:if>

<c:if test="${info == 1}">
	<script>
        alert("导入成功")
	</script>
</c:if>



</html>
