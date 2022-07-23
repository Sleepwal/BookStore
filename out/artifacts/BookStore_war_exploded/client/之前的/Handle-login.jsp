<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/31
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*,com.me.util.DbUtil"%>
<html>
<head>
    <title>Handle-login</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    int state = 0;
    state = login(username, password);

    if(state == 1){
        //账户密码正确，则跳回首页
        request.getSession().setAttribute("username", username);
        response.sendRedirect(request.getContextPath() + "/client/loginsuccess.jsp");
    }
    else{
        //账号密码错误
        session.setAttribute("Message", "账号密码错误");
        response.sendRedirect(request.getContextPath() + "/client/loginfail.jsp");
    }
%>

<%!
    public int login(String username, String password){
    //根据登录时表单输入的用户名和密码，查找用户
    int state = -1;

    /*Connection conn = null;*/
    PreparedStatement ps = null;
    ResultSet rs = null;
    String strSQL = "select username,password from user where username = ? and password = ?";
    try {
        /*Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","166");

        ps =  conn.prepareStatement(strSQL);*/
        ps = DbUtil.executePreparedStatement(strSQL);
        ps.setString(1,username);
        ps.setString(2,password);
        rs = ps.executeQuery();

        while (rs.next()) {
            state = 1;
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }finally {
        DbUtil.close();
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       /*if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    return state;
}
%>

</body>
</html>
