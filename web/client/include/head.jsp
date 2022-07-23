<%@ page import="java.awt.*" %>
<%@ page import="com.me.util.OnlineCounter" %><%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/10
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>head</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/ClientFindNoticeById">
        <img src="${pageContext.request.contextPath}/client/images/logo.jpg"/>
    </a>
    <div style="float: right;">
        <img src="${pageContext.request.contextPath}/client/images/cart.gif">
        <%--<a href="${pageContext.request.contextPath}/client/login/Cart.jsp" style="text-decoration: none">购物车</a>|--%>
        <a href="${pageContext.request.contextPath}/ShowCart?username=${username}" style="text-decoration: none">购物车</a>|
        <a>帮助中心</a>|
        <a href="${pageContext.request.contextPath}/client/login/MyAccount.jsp" style="text-decoration: none">我的账户</a>|
        <%--${sessionScope["username"]}--%>

        <c:choose>
            <c:when test="${username == null}">
                <a href="${pageContext.request.contextPath}/RegisterUI" style="text-decoration: none">新用户注册</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/Exit" style="text-decoration: none">用户退出</a>
                <div align="right">
                    欢迎您： ${username}
                </div>
            </c:otherwise>
        </c:choose>
        <%--<%
            /*response.sendRedirect(request.getContextPath() + "/client/login.jsp");*/
            String name = (String)session.getAttribute("username");
            if(name == null){
               //out.print("<a href='${pageContext.request.contextPath}/register.jsp' style=\"text-decoration: none\">新用户注册</a>");
            %>

           <% }
            else{
                //out.print("<a href='${pageContext.request.contextPath}/Handle-exit.jsp' style=\"text-decoration: none\">用户退出</a>");
            %>
            <%
                    out.print(name);
                    out.print("</div>");
                }
            %>--%>

        <%--<div align="right" style="color: brown">
            在线人数：<%= OnlineCounter.getCounter() %>
        </div>--%>
    </div>

</body>
</html>
