<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/4/18
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>handle-delete</title>
</head>
<body>
    <jsp:useBean id="product" class="com.me.domain.Product" scope="request"/>
    <jsp:setProperty name="product" property="*"/>
    <%
        product.update(product);
        response.sendRedirect(request.getContextPath()+ "/admin/login/home.jsp?item=product_list");
    %>
</body>
</html>
