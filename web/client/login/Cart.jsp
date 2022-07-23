<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/23
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
    <style>
        a{
            text-decoration: none;
        }
        a:hover{
             color:#F00;
             background: #7c0580
         }
    </style>
</head>
<body>

<%--1.顶部--%>
<%@include file="../include/head.jsp"%>
<%--2.菜单列表--%>
<%@include file="../include/menu_search.jsp"%>

<div align="center">
    <div align="right" style="width: 80%">
        <a href="index.jsp">首页</a>
         >
        购物车
    </div>
    <div>&nbsp;</div>

    <div style="border: 3px solid #8eff3b; width: 80%">
        <table style="width: 100%; border: 0; background-color: #e1ffe1" cellspacing='0' align="center">
            <tr>
                <td width='13%'>序号</td>
                <td width='20.2%'>商品名称</td>
                <td width='13%'>价格</td>
                <td width='9.5%'>库存</td>
                <td width='21%'>数量</td>
                <td>删除</td>
            <tr>

            </tr>
        </table>

        <c:forEach items="${cs}" var="cart" varStatus="state">
            <c:set var="total" scope="request">${total + cart.p.price * cart.num}</c:set>
            <form action="${pageContext.request.contextPath}/DelCart?id=${cart.p.id}&username=${username}" method="post">
                <div id="div${state.count}">
                    <table width="100%" border="0" cellspacing="0">
                        <tr>
                            <td width='13%'>
                                ${state.count}
                            </td>
                            <td width='21%'>
                                ${cart.p.name}
                            </td>
                            <td width='13%'>
                                ${cart.p.price}

                            </td>
                            <td width='10%'>
                                ${cart.p.pnum}
                            </td>
                            <td width='20%'>
                                ${cart.num}
                            </td>
                            <td width=30>
                                <button type="submit" style="color: #FF0000; font-weight: bold">x</button>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>

        </c:forEach>

        <%--<%!
            int price;
            int j;
            String book[][] = new String[4][4];
        %>--%>
        <%--<%
            book[0] =(String[]) session.getAttribute("book0");
            book[1] =(String[]) session.getAttribute("book1");
            book[2] =(String[]) session.getAttribute("book2");
            book[3] =(String[]) session.getAttribute("book3");
            j = 1;//  j 是图2中的序号，是动态生成表格的序号
            price = 0;
            for(int i = 0; i < 4;i++){
                if(book[i] != null){
                    out.println("<form action='DeleteCart.jsp?i="+i+"' method='post'>");
                    out.println("<div id='div"+i+"'>");
                    out.println("<table width='100%' border='0' cellspacing='0'>");
                    out.println("<tr><td width='13%'>" + j + "</td><td width='21%'>"+book[i][0] + "</td>");
                    out.println("<td width='13%'>"+book[i][1]+"</td>");
                    out.println("<td width='10%'>"+book[i][2]+"</td>");
                    out.println("<td width='20%'>"+book[i][3]+"</td>");
                    out.println("<td width=30><button style='color: #FF0000; font-weight: bold' onclick='return cart_del()'>x</button></td></tr>");
                    out.println("</table>");
                    out.println("</div>");
                    out.println("</form>");

                    if(book[i][1] != null)
                        price += Integer.parseInt(book[i][1]);
                    j++;
                }
            }
        %>--%>

        <div style="text-align: right; padding-right: 50px; background-color: #e1ffe1">
            合计：${total} 元
        </div>
    </div>


</div>

<%--4.下方显示--%>
<%@include file="../include/foot.jsp" %>

</body>
</html>
