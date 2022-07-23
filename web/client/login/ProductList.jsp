<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/23
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ProductList</title>
</head>
<body>

<%--<%
    String userName = (String)session.getAttribute("username");
    if(userName == null){
        response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/client/login.jsp");
    }
%>--%>

<%--1.顶部--%>
<%@include file="../include/head.jsp"%>
<%--2.菜单列表--%>
<%@include file="../include/menu_search.jsp"%>

<table align="center" style="border: 2px solid #fe26ff; padding: 55px">
    <tr><td><strong style="font-size: 35px">商品目录</strong></td></tr>
    <tr><td colspan="4">————————————————————————————————————————————————————</td></tr>
    <tr><td> &nbsp;&nbsp;&nbsp;Product List</td></tr>
    <tr><td colspan="4">————————————————————————————————————————————————————</td></tr>

    <tr>
        <c:forEach items="${ProductList}" var="p" varStatus="i">
            <%--从迭代参数p中取出产品的各个属性；--%>
            <td style="padding-left: 100px">
                <div class="divbookpic">
                    <p>
                        <img src="${pageContext.request.contextPath}/client/images/productImg/${p.imgurl}"
                             width="115" heicht="129" border="0"/>
                    </p>
                </div>
                <div class="divlisttitle">
                    <form action="${pageContext.request.contextPath}/AddCart?id=${p.id}&username=${username}" method="post">
                        书名:<input type="text" style="border:none" name="PName" value="${p.name}" readonly="readonly"/><br/>
                        售价:<input type="text" style="border:none" name="Price" value="${p.price}" readonly="readonly"/><br/>
                        库存:<input type="text" style="border:none" name="PNum" value="${p.pnum}" readonly="readonly"/><br/>
                        <input type="submit" name="book0" value="购买"/>
                    </form>
                </div>
            </td>

        </c:forEach>
        <%--<td>
            <div class="divbookpic">
                <p>
                    <img src="images/productImg/a2da626c-c72d-4972-83de-cf48405c5563.jpg"
                         width="115" heicht="129" border="0"/>
                </p>
            </div>

            <div class="divlisttitle">
                <form action="Handle-AddCart.jsp" method="post">
                    书名:<input type="text" style="border:none" name="PName" value="学会宽容" readonly="readonly"/><br/>
                    售价:<input type="text" style="border:none" name="Price" value="25" readonly="readonly"/><br/>
                    库存:<input type="text" style="border:none" name="PNum" value="15" readonly="readonly"/><br/>
                    <input type="submit" name="book1" value="购买"/>
                </form>
            </div>
        </td>
        <td>
            <div class="divbookpic">
                <p>
                    <img src="images/productImg/c4ab442f-95c7-4d6f-a57e-3eb7dc6b83c4.jpg"
                         width="115" heicht="129" border="0"/>
                </p>
            </div>

            <div class="divlisttitle">
                <form action="Handle-AddCart.jsp" method="post">
                    书名:<input type="text" style="border:none" name="PName" value="杜拉拉升职记" readonly="readonly"/><br/>
                    售价:<input type="text" style="border:none" name="Price" value="54" readonly="readonly"/><br/>
                    库存:<input type="text" style="border:none" name="PNum" value="25" readonly="readonly"/><br/>
                    <input type="submit" name="book2" value="购买"/>
                </form>
            </div>
        </td>
        <td>
            <div class="divbookpic">
                <p>
                    <img src="images/productImg/697a23d6-225a-41a3-8c20-7ab624265ecc.png"
                         width="115" heicht="129" border="0"/>
                </p>
            </div>

            <div class="divlisttitle">
                <form action="Handle-AddCart.jsp" method="post">
                    书名:<input type="text" style="border:none" name="PName" value="Java基础入门" readonly="readonly"/><br/>
                    售价:<input type="text" style="border:none" name="Price" value="45" readonly="readonly"/><br/>
                    库存:<input type="text" style="border:none" name="PNum" value="20" readonly="readonly"/><br/>
                    <input type="submit" name="book3" value="购买"/>
                </form>
            </div>
        </td>--%>
    </tr>
</table>

<%--4.下方显示--%>
<%@include file="../include/foot.jsp" %>

</body>
</html>
