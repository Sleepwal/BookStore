<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/5/19
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>userList</title>
</head>
<body>
<br/>
<form id="Form1" name="Form1" action="" method="post">
    <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
        <tr>
            <td align="center" bgColor="#afd1f3"><strong>查 询 条 件</strong></td>
        </tr>
        <tr>
            <td>
                <br/>
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tr>
                        <td height="22" align="center" bgColor="#f5fafe">用户ID：</td>
                        <td bgColor="#ffffff">
                            <input type="text" name="" size="15" value="" />
                        </td>
                        <td height="22" align="center" bgColor="#f5fafe">用户名：</td>
                        <td bgColor="#ffffff">
                            <input type="text" name="" size="15" value=""/>
                        </td>

                    <tr>
                        <td width="100" height="22" align="center" bgColor="#f5fafe"></td>
                        <td bgColor="#ffffff"><font face="宋体"
                                                    color="red"> &nbsp;</font></td>
                        <td align="right" bgColor="#ffffff"><br /> <br /></td>
                        <td align="right" bgColor="#ffffff">
                            <button type="submit" id="search" name="search" value="查询">
                                查询</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" name="reset" value="重置" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#afd1f3"><strong>用 户 列 表</strong></TD>
        </tr>
        <tr>
            <td align="right">
                <button type="button" id="add" name="add" value="添加"
                        onclick="addProduct()">
                    添加</button>
            </td>
        </tr>
        <tr>
            <td align="center" bgColor="#f5fafe">
                <table cellspacing="0" cellpadding="1" rules="all"
                       bordercolor="gray" border="1" id="DataGrid1"
                       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                    <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                        <td align="center" width="4%">用户ID</td>
                        <td align="center" width="8%">用户名</td>
                        <td align="center" width="7%">密码</td>
                        <td align="center" width="5%">性别</td>
                        <td width="12%" align="center">邮箱</td>
                        <td align="center" width="11%">电话</td>
                        <td width="10%" align="center">自我介绍</td>
                        <td width="8%" align="center">用户类型</td>
                        <td width="14%" align="center">注册时间</td>
                        <td width="8%" align="center">查看</td>
                        <td width="8%" align="center">删除</td>
                    </tr>
                    <%--循环遍历集合us中的成员--%>
                    <%--<c:forEach items="${us}" var="user">--%>
                    <c:forEach items="${pageHelp.list}" var="user">
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#fff663';">
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.id}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.username}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.password}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.gender}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.email}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.telephone}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.introduce}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.role}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                    ${user.registTime}
                            </td>

                            <!-- 查看 -->
                            <td align="center" style="HEIGHT: 22px">
                                <a href="${pageContext.request.contextPath}/FindOrderByIdServlet?id=${user.id}">
                                    <input type="button" style="color: #2fd529; font-weight: bold" value="✎"/>
                                </a>
                            </td>
                            <!-- 删除 -->
                            <td align="center" style="HEIGHT: 22px">
                                <a href="${pageContext.request.contextPath}/DeleteUser?id=${user.id}">
                                    <input type="button" style="color: #FF0000; font-weight: bold" value="✖"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>


    <br/>
    <br/>
    <center>
        <%-- curPage 传递给servlet的参数，代表当前页，mysql从0开始计数 --%>
        <a href="QueryUserByPage?curPage=0">首页</a>
        <a href="QueryUserByPage?curPage=${pageHelp.currentPage-1}">上一页 </a>
        <a href="QueryUserByPage?curPage=${pageHelp.currentPage+1}">下一页  </a>
        <a href="QueryUserByPage?curPage=${pageHelp.totalPage-1}">尾页</a>
    </center>

</form>
</body>
</html>
