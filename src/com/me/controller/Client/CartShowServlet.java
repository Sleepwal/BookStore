package com.me.controller.Client;

import com.me.domain.Cart;
import com.me.factory.ServiceFactory;
import com.me.service.ICartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartShowServlet", value = "/ShowCart")
public class CartShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        ICartService cartService = ServiceFactory.getCartServiceInstance();
        List<Cart> cs = cartService.showAll(username);

        request.setAttribute("cs", cs);
        request.getRequestDispatcher("/client/login/Cart.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
