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

@WebServlet(name = "UserFindByNameServlet", value = "/FindUserByName")
public class UserFindByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        IUserService userService = ServiceFactory.getUserServicenstance();
        User user = userService.findByName(name);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/client/login/MyAccount.jsp?item=user_list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
