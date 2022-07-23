package com.me.controller.Client;

import com.me.domain.User;
import com.me.exception.UserExistException;
import com.me.factory.ServiceFactory;
import com.me.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole((usertype.equals("0")) ? "管理员" : "普通用户");

        IUserService service  = ServiceFactory.getUserServicenstance();
        HttpSession session = request.getSession();

        try{
            service.login(user);
            session.setAttribute("username", username);
        }
        catch (UserExistException e) {
            session.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("/client/loginfail.jsp").forward(request, response);
            /*response.sendRedirect(request.getContextPath() + );*/
        } finally {
            if(usertype.equals("1"))
                request.getRequestDispatcher("/client/loginsuccess.jsp").forward(request, response);
            else if(usertype.equals("0"))
                request.getRequestDispatcher("/admin/login/home.jsp").forward(request, response);
            else {
                session.setAttribute("username", null);
                request.getRequestDispatcher("/client/loginfail.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
