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
    <style type="text/css">
        #leftTable{
            border-spacing: 30px;
        }

        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <table id="leftTable">
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/"
                   target="_self" style="text-decoration: none;">我的收藏</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/"
                   target="_self" style="text-decoration: none;">我的收货地址</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/"
                   target="_self" class="left_list">我的订单</a>
            </td>
        </tr>
        <tr>
            <td class="underLine">
                <a href="${pageContext.request.contextPath}/FindUserByName?name=${username}" target="_self"
                   class="left_list">我的信息</a>
            </td>
        </tr>
    </table>
</body>
</html>
