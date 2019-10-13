<%--
  Created by IntelliJ IDEA.
  User: CXH
  Date: 2019/8/25
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/testImport" method="post" enctype="multipart/form-data" >
        <input type="file" name="file">
        <input type="submit" value="tijiao">
    </form>
</body>
</html>
