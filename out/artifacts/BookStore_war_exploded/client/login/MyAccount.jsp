<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/19
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyAccount</title>
    <style type="text/css">
        #menu{
            background-color:#EEEEEE;
            float:left;
            width:15%;
            height:70%;
        }
        #content{
            height:200px;
            width:85%;
            height:70%;
            float:left;
        }
    </style>
</head>
<body>

<%--1.顶部--%>
<%@include file="../include/head.jsp"%>
<%--2.菜单列表--%>
<%@include file="../include/menu_search.jsp"%>

<div id="menu">
    <%@include file="../include/account/myLeft.jsp"%>
</div>

<div  id="content">
    <c:choose>
        <c:when test="${param.item == 'user_list'}">
            <jsp:include page="../include/account/message.jsp" />
        </c:when>
        <c:otherwise>
            主页
        </c:otherwise>
    </c:choose>
</div>


<%--4.下方显示--%>
<%@include file="../include/foot.jsp" %>


</body>
</html>
