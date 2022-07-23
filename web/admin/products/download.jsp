<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/4
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>download</title>
</head>
<body>
    <div>&nbsp;</div>
    <div align="center" style="background-color: #afd1f3"><strong>查 询 条 件</strong></div>
    <div>&nbsp;</div>
    <form action="${pageContext.request.contextPath }/DownloadServlet">
        <div>
            <label>
                &nbsp;&nbsp;&nbsp;请输入年份:
                <input name="year" type="text"/>
            </label>
            <div style="float: right; padding-right: 150px; ">
                请输入月份：
                <select name="month" id="month">
                    <option value="0">--选择月份--</option>
                    <option value="1">一月</option>
                    <option value="2">二月</option>
                    <option value="3">三月</option>
                    <option value="4">四月</option>
                    <option value="5">五月</option>
                    <option value="6">六月</option>
                    <option value="7">七月</option>
                    <option value="8">八月</option>
                    <option value="9">九月</option>
                    <option value="10">十月</option>
                    <option value="11">十一月</option>
                    <option value="12">十二月</option>
                </select>
            </div>
        </div>
        <div>&nbsp;</div>
        <div style="text-align: right; padding-right: 100px">
            <input type="submit" value="下载"/>
            <input type="reset"/>
        </div>
    </form>



</body>
</html>
