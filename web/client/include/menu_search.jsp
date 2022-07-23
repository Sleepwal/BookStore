<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/10
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu_search</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/menu.css"/>
</head>
<body>
    <div id="commodity">
        <ul>
            <li><a>文学</a></li>
            <li><a>生活</a></li>
            <li><a>计算机</a></li>
            <li><a>外语</a></li>
            <li><a>外语</a></li>
            <li><a>经验</a></li>
            <li><a>励志</a></li>
            <li><a>社科</a></li>
            <li><a>学术</a></li>
            <li><a>少儿</a></li>
            <li><a>艺术</a></li>
            <li><a>原版</a></li>
            <li><a>科技</a></li>
            <li><a>考试</a></li>
            <li><a>生活百科</a></li>
            <li><%--<a href="${pageContext.request.contextPath}/client/ProductList.jsp"><em>全部商品目录</em></a>--%>
                <a href="${pageContext.request.contextPath}/MenuSearchServlet"><em>全部商品目录</em></a></li>
        </ul>
    </div>

    <form id="searchBg"  action="${pageContext.request.contextPath}/MenuSearchServlet">
        <div id="search">
            Search
            <input type="text" placeholder="请输入书名" name="textfield"/>
            <input type="image" src="${pageContext.request.contextPath}/client/images/serchbutton.gif"/>
        </div>
    </form>

</body>
</html>
