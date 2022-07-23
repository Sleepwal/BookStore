<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/8
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>index</title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/autoplay.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/autoplay.js"></script>
  </head>
  <body>

<%--1.顶部--%>
<%@include file="../include/head.jsp"%>
<%--2.菜单列表--%>
<%@include file="../include/menu_search.jsp"%>

<%-- 3.轮播 --%>
  <div id="box_autoplay">
      <div class="list">
        <ul>
            <c:forEach items="${as}" var="auto">
                <li><img src="${pageContext.request.contextPath}/client/images/ad/${auto.image}" width="900" height="335"/></li>
            </c:forEach>
            <%--
            <li><img src="${pageContext.request.contextPath}/client/images/ad/index_ad1.jpg" width="900" height="335"/></li>
            <li><img src="${pageContext.request.contextPath}/client/images/ad/index_ad2.jpg" width="900" height="335"/></li>
            <li><img src="${pageContext.request.contextPath}/client/images/ad/index_ad3.jpg" width="900" height="335"/></li>
            --%>
        </ul>
      </div>
  </div>

<%-- 公告板 --%>
<div>
    <table id="announcement_board">
        <tr>
            <td><img src="${pageContext.request.contextPath}/client/images/billboard.gif"></td>
            <td><img src="${pageContext.request.contextPath}/client/images/hottitle.gif"></td>
        </tr>
        <tr>
            <td width="500">
                <dl>
                    <dt>${n.title}</dt>
                    <dd>${n.details}</dd>
                </dl>
            </td>
        </tr>
    </table>
</div>

  <%--4.下方显示--%>
  <%@include file="../include/foot.jsp" %>

    <%--<%
        String userName = (String)session.getAttribute("username");
        if(userName == null){
            response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/client/login.jsp");
//            response.sendRedirect(request.getContextPath() + "/client/login.jsp");
        }
    %>--%>
  </body>
</html>
