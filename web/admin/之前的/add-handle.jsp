<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/4/6
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.me.domain.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add-handle.jsp</title>
    <meta http-equiv="Content-Language" content="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <%  request.setCharacterEncoding( "UTF-8");%>
    <jsp:useBean id="product" class="com.me.domain.Product" scope="request" />
    <jsp:setProperty name="product" property="*" />
    <%
//        product.add(product);
        response.sendRedirect(request.getContextPath()+ "/admin/login/home.jsp?item=product_list");
    %>

</body>
</html>
<%--
/*p.setId(product.getId());
p.setName(product.getName());
p.setPrice(product.getPrice());
p.setCategory(product.getCategory());
p.setPnum(product.getPnum());
p.setImgurl(product.getImgurl());
p.setDescription(product.getDescription());
*/--%>
