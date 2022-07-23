<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/8
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户注册</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script src="../../WEB-INF/lib/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/form.js"></script>
</head>
<body>
<%--1.顶部--%>
<%@include file="../include/head.jsp"%>
<%--2.菜单列表--%>
<%@include file="../include/menu_search.jsp"%>

<form id="form" action="${pageContext.request.contextPath}/Register" method="post">
    <input type="button" id="change" value="深色模式"/>

    <h1 align="center">新用户注册</h1>

    <table align="center">
        <tr>
            <td>电子邮箱：</td>
            <td>
                <input type="email" name="email" id="txtMail" />
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="370px"><span id="tips_email">*请填写常用的EMAIL，将用于密码找回</span></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="txtUser" /></td>
            <td></td>
            <td><span id="tips_username">*请输入用户名</span></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>

        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="txtPwd"/></td>
            <td></td>
            <td><span id="tips_password">*密码由6-18位字符组成，且必须包含字母、数字和标点符号</span></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" name="checkpassword" id="txtRpt"/></td>
            <td></td>
            <td><span id="tips_checkpassword">*请再次输入你的密码</span></td>
        </tr>
        <%--<tr>
            <td>用户类型：</td>
            <td>
                <select name="usertype" id="selUser">
                    <option value="0">--请选择--</option>
                    <option value="1">管理员</option>
                    <option value="2">普通用户</option>
                </select>
            </td>
            <td></td>
            <td><span id="tips_usertype">请选择用户类型</span></td>
        </tr>--%>
        <tr>
            <td>性别：</td>
            <td>
                <input type="radio" name="sex" id="sex" value="male" onclick="checkSex()"/>男
                <input type="radio" name="sex" value="female" onclick="checkSex()" />女
            </td>
            <td></td>
            <td><span id="tips_sex">请选择你的性别</span></td>
        </tr>
        <tr>
            <td>国籍：</td>
            <td>
                <select id="nation"><!--multiple="multiple"-->
                    <option selected="selected">--请选择国籍--</option>
                    <option  name="country" value="CN">中国</option>
                    <option name="country" value="USA">自由美利坚</option>
                    <option name="country" value="JP">小日本</option>
                </select>
            </td>
            <td></td>
            <td><span id="tips_nation">请选择你的国籍</span></td>
        </tr>
        <tr>
            <td>联系电话：</td>
            <td>
                <input type="text" id="phoneNum" name="telephone"/>

            </td>
            <td></td>
            <td><span id="tips_phone">*请输入你的电话号码</span></td>
        </tr>
        <tr>
            <td>自我介绍：</td>
            <td>
                <textarea name="introduction" rows="5" cols="40" id="txtIntro"></textarea>
            </td>
            <td></td>
            <td><span id="tips_introduction">*限100字以内</span></td>
        </tr>
        <tr>
            <!--        <td><input type="image" src="signup.png" value="提交" onclick="checkForm()"><br/></td>-->
            <td></td>
            <!--            <td align="center"><input id="submit" type="image" src="image/signup.png" onclick="return checkForm()" alt="Submit"/></td>-->
            <td align="center"><input id="submit" type="image" src="../images/signup.gif" alt="Submit"/></td>
        </tr>
        <tr>
            <td></td>
            <td align="center"><input type="reset"/></td>
        </tr>

    </table>

    <%--4.下方显示--%>
    <%@include file="../include/foot.jsp" %>

</form>
</body>
</html>
