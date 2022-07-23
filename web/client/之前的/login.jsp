<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/31
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <%--1.顶部--%>
    <%@include file="../include/head.jsp"%>
    <%--2.菜单列表--%>
    <%@include file="../include/menu_search.jsp"%>

<%--    <form id="form" action="Handle-login.jsp" method="post">--%>
    <form id="form" action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <h1 align="center">个人用户登录</h1>

        <table align="center">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" id="txtUser" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" id="txtPwd"/></td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><input id="submit" type="submit" value="登录"/></td>
            </tr>
        </table>


    </form>

    <%--4.下方显示--%>
    <%@include file="../include/foot.jsp" %>
</body>
</html>
