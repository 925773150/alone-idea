<%--
  Created by IntelliJ IDEA.
  User: 张国栋爸爸
  Date: 2020/09/24
  Time: 下午 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>系统主页</h1>
    <a href="${pageContext.request.contextPath}/user/logout">退出用户</a>
    <ul>
        <shiro:hasAnyRoles name="user,admin"><%--多个用户验证--%>
            <li><a href="">系统管理系统</a>
                <ul>
                <shiro:hasPermission name="user:add:*">
                    <li><a href="">增加</a></li>
                </shiro:hasPermission>
                    <shiro:hasPermission name="user:add:*">
                        <li><a href="">删除</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user:update:*">
                        <li><a href="">修改</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user:find:*">
                        <li><a href="">查询</a></li>
                    </shiro:hasPermission>
            </ul>
            </li>
        </shiro:hasAnyRoles>
        <shiro:hasRole name="admin"><%--一个用户验证--%>
            <li><a href="">订单管理系统</a></li>
            <li><a href="">账单管理系统</a></li>
            <li><a href="">物流管理系统</a></li>
        </shiro:hasRole>
    </ul>
</body>
</html>
