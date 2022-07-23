<%@ page import="javafx.scene.control.Alert" %><%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/4/18
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
    <jsp:useBean id="product" scope="request" class="com.me.domain.Product"/>
    <%
        product.delete(request.getParameter("id"));
        response.sendRedirect(request.getContextPath()+ "/admin/login/home.jsp?item=product_list");
    %>

</body>
</html>
