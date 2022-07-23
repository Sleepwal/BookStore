package com.me.controller.Admin;

import com.me.domain.User;
import com.me.factory.ServiceFactory;
import com.me.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserFindAllServlet", value = "/FindAllUser")
public class UserFindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = ServiceFactory.getUserServicenstance();
        List<User> us = userService.showUser();

        request.setAttribute("us", us);
        request.getRequestDispatcher("/admin/login/home.jsp?item=user_list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
