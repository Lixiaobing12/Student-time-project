<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登陆页</title>
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
    <form action="${pageContext.request.contextPath}/student/updatePassword" id="updateForm" method="post">
        <div id="loginBox">
            <div class="registeUserBox">
                <div>旧密码：</div>
                <input type="password" name="password" id="oldPass">
            </div>
            <div class="registePassWordBox">
            <div>新密码：</div>
                <input type="password" name="newPassword" id="newPass">
            </div>
            <div class="registeClassBox">
                <div>确认密码：</div>
                <input type="password" name="surPassword" id="SnewPass">
            </div>
            <button id="updBtn" class="btn">确定</button>
            <a href="${pageContext.request.contextPath}/student/toStudent">返回</a>
        </div>
        <%--<div id="registeBox">--%>
            <%--<div class="registeUserBox">--%>
                <%--<div>旧密码：</div>--%>
                <%--<input type="password" name="password" id="oldPass">--%>
            <%--</div>--%>
            <%--<div class="registePassWordBox">--%>
                <%--<div>新密码：</div>--%>
                <%--<input type="password" name="newPassword" id="newPass">--%>
            <%--</div>--%>
            <%--<div class="registeClassBox">--%>
                <%--<div>确认密码：</div>--%>
                <%--<input type="text" name="surPassword" id="SnewPass">--%>
            <%--</div>--%>
            <%--<button id="updBtn">确定</button>--%>
        <%--</div>--%>
    </form>
</div>
<c:if test="${updateInfo == 0}">
    <script>
        alert("旧密码输入错误")
    </script>
</c:if>
<c:if test="${updateInfo == -1}">
    <script>
        alert("两次输入密码不匹配")
    </script>
</c:if>

<script type="javascript">
    document.getElementById("updBtn").onclick = function () {
        var password = document.getElementById("newPass").value;
        var realPassword = ${sessionScope.student.password};
        var sPassword = document.getElementById("SnewPass").value;
        if (password == "" || realPassword == "" || sPassword == "") {
            alert("输入不能为空")
        }else if (password != realPassword) {
            alert("旧密码输入错误")
        } else if (password != sPassword) {
            alert("两次输入密码不匹配")
        } else {
            var form = document.getElementById("updateForm");
            form.submit();
        }
    }
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/login.js"></script>
</body>
</html>
