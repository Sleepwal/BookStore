<%--
  Created by IntelliJ IDEA.
  User: manson
  Date: 2022/3/31
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<%@ page import="com.me.util.DbUtil" %>
<html>
<head>
    <title>Handle-register</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("sex");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String introduce = request.getParameter("introduction");

        /*Connection conn = null;*/
        PreparedStatement ps = null;
        String strSQL = "insert into user(username,password,gender,email,telephone,introduce) values(?,?,?,?,?,?)";
        try {
            /*Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","166");

            ps =  conn.prepareStatement(strSQL);*/
            ps = DbUtil.executePreparedStatement(strSQL);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,gender);
            ps.setString(4,email);
            ps.setString(5,telephone);
            ps.setString(6,introduce);

            ps.executeUpdate();
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
        }

        response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
    %>

</body>
</html>
