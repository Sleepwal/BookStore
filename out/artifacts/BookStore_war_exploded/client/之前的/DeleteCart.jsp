<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/23
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteCart</title>
</head>
<body>
<%
    String  Detele_book = "book" + request.getParameter("i");
    session.removeAttribute(Detele_book);
%>

<jsp:forward page="../login/Cart.jsp"></jsp:forward>

</body>
</html>
