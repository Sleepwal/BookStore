<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/25
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editNotice</title>
</head>
<body>
<form id="userAction_save_do" name="Form1"
      action="${pageContext.request.contextPath}/UpdateNotice?id=${n.n_id}" method="post">
    &nbsp;
    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td align="center" bgColor="#afd1f3" colSpan="4"
                height="26"><strong><STRONG>修 改 公 告</STRONG> </strong>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">公告标题：</td>
            <td bgColor="#ffffff">
                <input type="text" name="title" value="${n.title}"
             style="border-left-style: none; border-right-style: none; border-top-style: none" /></td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">公告内容：</td>
            <td bgColor="#ffffff" colSpan="3">
                <textarea name="details" cols="30" rows="3" style="WIDTH: 96%">
                    ${n.details}
                </textarea>
            </td>
        </tr>
        <tr>
            <td style="WIDTH: 100%" align="center"
                bgColor="#f5fafe" colSpan="4">
                <input type="submit" value="确定">
                <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
                <input type="reset" value="重置" >
                <FONT face="宋体">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </FONT>
                <INPUT type="button" onclick="history.go(-1)" value="返回" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
