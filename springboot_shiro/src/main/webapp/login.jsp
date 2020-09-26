<%--
  Created by IntelliJ IDEA.
  User: 张国栋爸爸
  Date: 2020/09/24
  Time: 下午 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>用户登录</h1>
    <form action="${pageContext.request.contextPath}/user/login">
        用户名：<input type="text" name="username"/>
        密码：<input type="password" name="password"/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
