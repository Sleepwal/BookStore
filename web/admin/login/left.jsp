<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/16
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>left</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/login/css/left.css"/>
</head>
<body>
    <table id="leftTable">
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/FindProductServlet"
                   target="_self" style="text-decoration: none;">商品管理</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <%--<a href="${pageContext.request.contextPath}/FindAllUser"--%>
                <a href="${pageContext.request.contextPath}/QueryUserByPage"
                   target="_self" style="text-decoration: none;">用户管理</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/admin/login/home.jsp?item=${"download"}"
                   target="_self" class="left_list">销售榜单</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/FindOrdersServlet" target="_self"
                   class="left_list">订单管理 </a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/ShowAllNotice" target="_self"
                   class="left_list">公告管理</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/ShowAllAutoImage" target="_self"
                   class="left_list">轮播图管理</a>
            </td>
        </tr>
    </table>
</body>
</html>
