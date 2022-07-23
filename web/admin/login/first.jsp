<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/17
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first</title>
</head>
<body>
    <jsp:forward page="home.jsp">
        <jsp:param name="Str" value="这是使用jsp:从first页面跳转过来的~"/>
    </jsp:forward>
</body>
</html>
