<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/4/1
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exit</title>
</head>
<body>
    <%
        session.setAttribute("username",null);
        response.sendRedirect(request.getContextPath() + "/client/login.jsp");
    %>

</body>
</html>
