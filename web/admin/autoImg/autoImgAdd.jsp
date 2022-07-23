<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/28
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>autoAdd</title>
</head>
<body>

    &nbsp;
<table cellSpacing="1" cellPadding="5" width="100%" align="center"
       bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
    <tr>
        <td align="center" bgColor="#afd1f3" colSpan="4"
            height="26"><strong><STRONG>添 加 轮 播 图</STRONG> </strong>
        </td>
    </tr>
    <tr>
        <td colspan="6">
            <form action="${pageContext.request.contextPath}/UploadwithServlet" method="post" ENCTYPE="multipart/form-data">
                <INPUT type="FILE" name="fileName">
                <BR> <INPUT type="submit" name ="upload" value="上传">
            </form>
        </td>

    </tr>
    <tr>
        <td>
            <form id="userAction_save_do" name="Form1"
                  action="${pageContext.request.contextPath}/AddAutoImg" method="post">
                <table cellSpacing="1" cellPadding="5" width="100%" align="center"
                       bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
                    <tr>
                        <td></td>
                        <td align="center" bgColor="#f5fafe">选择图片：</td>
                        <td bgColor="#ffffff" colspan="3">
                            <input type="file" name="img" accept=".jpg ,.gif (*.gif)"  size="30" value="" />
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
        </td>
    </tr>


</table>


</body>
</html>
