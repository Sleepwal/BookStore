<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/31
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginfail</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/my.js"></script>
</head>
<body>
    <%--1.顶部--%>
    <%@include file="include/head.jsp"%>
    <%--2.菜单列表--%>
    <%@include file="include/menu_search.jsp"%>`


    <table style="padding-left: 230px; padding-top: 80px; padding-bottom: 80px">
        <tr>
            <td><img src="${pageContext.request.contextPath}/client/images/IconTexto_WebDev_009.jpg"></td>
            <td>
                <div>
                    <strong style="color: red">${sessionScope.message}</strong>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/LoginUI">
                        <span id="second">5</span>秒后自动为您转跳回登录界面
                    </a>
                </div>
            </td>
        </tr>
    </table>


    <%--4.下方显示--%>
    <%@include file="include/foot.jsp" %>
</body>
</html>
