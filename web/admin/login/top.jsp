<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/16
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date" %>
<html>
<head>
    <title>top</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/login/css/top.css"/>
    <script type="text/javascript">
        setInterval("Data.innerHTML = new Date().toLocaleString()+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());",1000);
    </script>
</head>
<body>
    <div id="title">
        <strong>网上书城后台管理系统</strong>
    </div>

    <input type="button" id="exit" value="退出系统"/>

    <div id="Data">
        <%= new Date().toLocaleString()+" 星期"+"日一二三四五六".charAt(new Date().getDay()) %>
    </div>

</body>
</html>
