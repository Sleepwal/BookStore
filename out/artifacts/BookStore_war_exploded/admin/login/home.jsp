<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/16
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/login/css/homeCss.css" />
</head>
<body>
    <div id="container">
        <div id="header">
            <%@include file="top.jsp"%>
        </div>

        <div id="menu">
            <jsp:include page="left.jsp" />
        </div>

        <div id="content">
            <c:choose>
                <c:when test="${param.item == 'product_list'}">
                    <jsp:include page="../products/list.jsp" />
                </c:when>
                <c:when test="${param.item == 'product_add'}">
                    <jsp:include page="../products/add.jsp" />
                </c:when>
                <c:when test="${param.item == 'product_update'}">
                    <jsp:include page="../products/update.jsp" />
                </c:when>

                <c:when test="${param.item == 'download'}">
                    <jsp:include page="../products/download.jsp" />
                </c:when>

                <c:when test="${param.item == 'orders'}">
                    <jsp:include page="../orderList.jsp" />
                </c:when>
                <c:when test="${param.item == 'view'}">
                    <jsp:include page="../orders/orderView.jsp" />
                </c:when>

                <c:when test="${param.item == 'user_list'}">
                    <jsp:include page="../user/userList.jsp" />
                </c:when>

                <c:when test="${param.item == 'notice_list'}">
                    <jsp:include page="../notice/noticeList.jsp" />
                </c:when>
                <c:when test="${param.item == 'notice_add'}">
                    <jsp:include page="../notice/addNotice.jsp" />
                </c:when>
                <c:when test="${param.item == 'notice_edit'}">
                    <jsp:include page="../notice/editNotice.jsp" />
                </c:when>

                <c:when test="${param.item == 'autoimg_list'}">
                    <jsp:include page="../autoImg/autoImgList.jsp" />
                </c:when>
                <c:when test="${param.item == 'autoimg_add'}">
                    <jsp:include page="../autoImg/autoImgAdd.jsp" />
                </c:when>

                <c:otherwise>
                    <div style="font-size: 37px">
                        <jsp:include page="/admin/login/welcome.jsp" />
                    </div>
                </c:otherwise>
            </c:choose>

            <%--<%
            if(Objects.equals(request.getParameter("item"), "product_list")){ %>
            <% }
                else if(Objects.equals(request.getParameter("item"), "product_add")){ %>
                <jsp:include page="../products/add.jsp" />
            <% }
                else if(Objects.equals(request.getParameter("item"), "product_update")){ %>
                <jsp:include page="../products/update.jsp" />
            <% }
                else if(Objects.equals(request.getParameter("item"), "download")){ %>
                <jsp:include page="../products/download.jsp" />
            <% }
                else if(Objects.equals(request.getParameter("item"), "orders")){ %>
                <jsp:include page="../orderList.jsp" />
            <% }
                else if(Objects.equals(request.getParameter("item"), "view")){ %>
                <jsp:include page="../orders/orderView.jsp" />
            <% }
                else { %>
                <div style="font-size: 37px">
                    <jsp:include page="/admin/login/welcome.jsp" />
                </div>
            <% } %>--%>
        </div>

        <div id="footer">
            <%@include file="bottom.jsp"%>
        </div>
    </div>

</body>
</html>
