package com.me.controller.Client;

import com.me.factory.ServiceFactory;
import com.me.service.ICartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartAddServlet", value = "/AddCart")
public class CartAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("id");
        String username = request.getParameter("username");
        ICartService cartService = ServiceFactory.getCartServiceInstance();
        cartService.add(product_id, username);

        request.getRequestDispatcher("/ShowCart").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
