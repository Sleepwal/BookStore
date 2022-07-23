<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/11
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.me.domain.Order" %>
<%@ page import="com.me.dao.OrderDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>orderList</title>
</head>
<body>
<br/>
<form id="Form1" name="Form1" action="" method="post">
    <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
        <tr>
            <td align="center" bgColor="#afd1f3"><strong>查 询 条 件</strong></td>
        </tr>
        <tr>
            <td>
                <br/>
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tr>
                        <td height="22" align="center" bgColor="#f5fafe">订单编号：</td>
                        <td bgColor="#ffffff">
                            <input type="text" name="" size="15" value="" />
                        </td>
                        <td height="22" align="center" bgColor="#f5fafe">收件人：</td>
                        <td bgColor="#ffffff">
                            <input type="text" name="" size="15" value=""/>
                        </td>

                    <tr>
                        <td width="100" height="22" align="center" bgColor="#f5fafe"></td>
                        <td bgColor="#ffffff"><font face="宋体"
                                                    color="red"> &nbsp;</font></td>
                        <td align="right" bgColor="#ffffff"><br /> <br /></td>
                        <td align="right" bgColor="#ffffff">
                            <button type="submit" id="search" name="search" value="查询">
                                查询</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" name="reset" value="重置" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#afd1f3"><strong>订 单 列 表</strong></TD>
        </tr>
        <tr>
            <td align="right">
                <button type="button" id="add" name="add" value="添加"
                        onclick="addProduct()">
                    添加</button>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">
                <table cellspacing="0" cellpadding="1" rules="all"
                       bordercolor="gray" border="1" id="DataGrid1"
                       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                    <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                        <td align="center" width="24%">订单编号</td>
                        <td align="center" width="9%">收件人</td>
                        <td align="center" width="18%">地址</td>
                        <td align="center" width="9%">联系电话</td>
                        <td width="8%" align="center">总价</td>
                        <td align="center" width="9%">所属用户</td>
                        <td width="8%" align="center">订单状态</td>
                        <td width="8%" align="center">查看</td>
                        <td width="8%" align="center">删除</td>
                    </tr>
                    <%--循环遍历集合orders中的成员--%>
                    <c:forEach items="${orders}" var="order">
                        <%
                        request.setCharacterEncoding("UTF-8");
                        response.setCharacterEncoding("UTF-8");
                        %>
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#fff663';">
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="200">
                                ${order.id}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="9%">
                                ${order.receiverName}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
                                ${order.receiverAddress}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                ${order.receiverPhone}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                ${order.money}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                ${order.user.username}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                ${order.paystate}
                            </td>

                            <!-- 查看 -->
                            <td align="center" style="HEIGHT: 22px" width="7%">
                                <a href="${pageContext.request.contextPath}/FindOrderByIdServlet?id=${order.id}">
                                    <input type="button" style="color: #2fd529; font-weight: bold" value="☑"/>
                                    <%--<img src="${pageContext.request.contextPath}/admin/images/i_scan.png"
                                            border="0" style="CURSOR: hand">--%>
                                    </a>
                            </td>
                            <!-- 删除 -->
                            <td align="center" style="HEIGHT: 22px" width="7%">
                                <a href="${pageContext.request.contextPath}/DelOrderByIdServlet?id=${order.id}">
                                    <input type="button" style="color: #FF0000; font-weight: bold" value="✖"/>
                                    <%--<img src="${pageContext.request.contextPath}/admin/images/i_del.gif"
                                         width="16" height="16" border="0" style="CURSOR: hand">--%>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>

</form>



</body>
</html>