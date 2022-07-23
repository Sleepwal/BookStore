package com.me.controller.Admin;

import com.me.factory.DaoFactory;
import com.me.dao.OrderDao;
import com.me.domain.Order;
import com.me.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindOrdersServlet")
public class OrdersFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = null;
        try {
            // orders=调用OrderService的findAllOrder()方法;
            orders = ServiceFactory.getOrderServiceInstance().findAllOrder();

            // 将查询到的订单链表信息orders添加到request作用域的"orders"变量中
            request.setAttribute("orders", orders);
            // 将请求转发到orderList.jsp页面并传递参数item="+"orders"
            request.getRequestDispatcher("/admin/login/home.jsp?item=" + "orders").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
