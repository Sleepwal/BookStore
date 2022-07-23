package com.me.controller.Admin;

import com.me.factory.ServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelOrderByIdServlet")
public class OrderDelByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从request中获取订单id的值
        String id = request.getParameter("id");

        // 删除order和orderItem的订单
        ServiceFactory.getOrderServiceInstance().deleteById(id);
        ServiceFactory.getOrderItemServiceInstance().deleteById(id);

        request.getRequestDispatcher("/FindOrdersServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
