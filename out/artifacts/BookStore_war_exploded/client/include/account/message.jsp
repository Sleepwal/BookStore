<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/19
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>

<form id="userAction_save_update" name="Form1"
      action="${pageContext.request.contextPath}/UpdateUser?id=${user.id}" method="post">
    &nbsp;
    <table cellSpacing="1" cellPadding="5" width="100%" align="center"
           bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
        <tr>
            <td align="center" colSpan="4" style="background-color: #73c139"
                height="26"><strong><STRONG>用 户 信 息</STRONG> </strong>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">用户名：</td>
            <td bgColor="#ffffff">
                <input type="text" name="username" placeholder="${user.username}"/>
            </td>
            <td align="center" bgColor="#f5fafe">密码：</td>
            <td bgColor="#ffffff">
                <input type="text" name="password" placeholder="${user.password}" />
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">邮箱：</td>
            <td bgColor="#ffffff">
                <input type="text" name="email" placeholder="${user.email}"/>
            </td>
            <td align="center" bgColor="#f5fafe">电话：</td>
            <td bgColor="#ffffff">
                <input type="text" name="telephone" placeholder="${user.telephone}"/>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">性别：</td>
            <td bgColor="#ffffff">
                <input type="radio" name="sex" id="sex" value="male"
                       checked="${user.gender = "male" ? "checked" : ""}"/>男
                <input type="radio" name="sex" value="female"
                       checked="${user.gender = "female" ? "checked" : ""}"/>女
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">自我介绍：</td>
            <td bgColor="#ffffff" colSpan="3">
                <textarea  cols="30" rows="3" style="WIDTH: 96%">
                    ${user.introduce}
                </textarea>
            </td>
        </tr>
        <tr>
            <td style="WIDTH: 100%" align="center"
                bgColor="#f5fafe" colSpan="4">
                <input type="submit" value="修改">
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
