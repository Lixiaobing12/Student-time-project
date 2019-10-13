<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/detailStyle.css">

    </head>

    <body>
        <img class="bg" src="${pageContext.request.contextPath}/resources/image/bg.jpg">
        <div class="box">

            <div class="containter">
                <div class="megbox">
                    <div class="title">
                        培养目标
                    </div>
                    <div class="mes">
                        ${direction.target}
                    </div>
                </div>
                <div class="megbox">
                    <div class="title">
                        方向介绍
                    </div>
                    <div class="mes">
                        ${direction.introduction}
                    </div>
                </div>
                <div class="megbox">
                    <div class="title">
                        老师简介
                    </div>
                    <c:forEach items="${direction.teachers}" var="item" >
                        <div class="mes">
                            名字：${item.name}
                        </div>
                        <div class="mes">
                            介绍：${item.introduction}
                        </div>
                    </c:forEach>
                </div>
                <div class="megbox">
                    <div class="title" id="courseTitle">
                        课程简介
                    </div>
                    <c:forEach items="${direction.courses}" var="item" >
                        <div class="mes" id="courseName" >
                            名称：${item.name}
                        </div>
                        <div class="mes" id="courseMes">
                            介绍：${item.introduction}
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>