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

<div>
    <form action="${pageContext.request.contextPath}/admin/dir/doUpdate" id="form">
        <input type="hidden" name="id" value="${id}">
        <img class="bg" src="${pageContext.request.contextPath}/resources/image/bg.jpg">
        <div class="box">
            <div class="title">修改方向关联课程</div>
            <div class="containter">
                <c:forEach items="${course}" var="item" >
                    <div><input class="check" name="cid"<c:if test="${fn:contains(courseList,item.id)}">checked="checked"</c:if> type="checkbox" value="${item.id}" />${item.name}</div>
                </c:forEach>
            </div>
            <div>
                <select name="majorId">
                    <c:forEach items="${major}" var="item" >
                        <option value ="${item.id}" <c:if test="${item.id==dir.major.id}">selected="selected"</c:if>>${item.name}</option>
                    </c:forEach>
                </select>
                <input class="input" type="text" name="name" value="${dir.name}" placeholder="方向名称"/>
                <input class="input" type="text" name="number" value="${dir.number}" placeholder="人数限制"/>
            </div>
            <div class="time">
                <div>开始时间<input type="text" id="start" value="${start}" name="start" onclick="WdatePicker()"/></div>
                <div>结束时间<input type="text" id="end" value="${end}"name="end" onclick="WdatePicker()"/></div>
            </div>
            <textarea rows="" cols="" name="intro" placeholder="方向介绍">${dir.introduction}</textarea>
            <textarea rows="" cols="" name="target" placeholder="培养目标">${dir.target}</textarea>
            <button onclick="document.getElementById('form').submit()" style="left:-150px">确认</button>
            <button class="btn"  onclick="history.back(-1)" style="left:70px">返回</button>

    </form>
</div>
</div>
</body>
</html>
