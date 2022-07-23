package com.me.controller.Client;

import com.me.domain.Sales;
import com.me.domain.User;
import com.me.factory.ServiceFactory;
import com.me.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet", value = "/UpdateUser")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt("".equals(request.getParameter("id"))?"0":request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setTelephone(request.getParameter("telephone"));
        user.setGender(request.getParameter("sex"));
        user.setIntroduce(request.getParameter("introduce"));

        IUserService userService = ServiceFactory.getUserServicenstance();
        userService.update(user);

        request.getRequestDispatcher("/FindUserByName?name=" + user.getUsername()).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
