<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/28
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>autoImg</title>
    <script type="text/javascript">
        //添加商品
        function addNotice() {
            window.location.href = "${pageContext.request.contextPath}/admin/login/home.jsp?item=autoimg_add";
        }
    </script>
</head>
<body>

<br/>
<form id="Form1" name="Form1" action="" method="post">
    <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">

        <tr>
            <td align="center" bgColor="#afd1f3"><strong>轮 播 图 列 表</strong></TD>
        </tr>
        <tr>
            <td align="right">
                <button type="button" id="add" name="add" value="添加"
                        onclick="addNotice()">
                    添加</button>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">
                <table cellspacing="0" cellpadding="1" rules="all"
                       bordercolor="gray" border="1" id="DataGrid1"
                       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                    <tr
                            style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                        <td align="center" width="5%">轮播图编号</td>
                        <td align="center" width="24%">轮播图URL</td>
                        <td width="8%" align="center">编辑</td>
                        <td width="8%" align="center">删除</td>
                    </tr>

                    <!--  循环输出所有 -->
                    <c:forEach items="${as}" var="auto">
                        <%--<jsp:useBean id="product" class="com.me.domain.Product" scope="request"/>--%>
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#fff663';">
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="200">
                                    ${auto.id}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="18%">
                                    ${auto.image}
                            </td>

                            <!-- 编辑 -->
                            <td align="center" style="HEIGHT: 22px" width="7%">
                                <a href="${pageContext.request.contextPath}/FindNoticeById?id=${auto.id}">
                                    <input type="button" style="color: #2fd529; font-weight: bold" value="✎"/>
                                </a>
                            </td>
                            <!-- 删除 -->
                            <td align="center" style="HEIGHT: 22px" width="7%">
                                <a href="${pageContext.request.contextPath}/DelAutoImg?id=${auto.id}">
                                    <input type="button" style="color: #FF0000; font-weight: bold" value="✖"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </td>
        </tr>
    </table>

</body>
</html>
