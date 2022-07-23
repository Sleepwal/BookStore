package com.me.controller.Admin;

import com.me.domain.Order;
import com.me.domain.OrderItem;
import com.me.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindOrderByIdServlet")
public class OrderFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request中获取订单id的值
        String id = request.getParameter("id");

        Order order = null;
        List<OrderItem> items = null;
        try{
            order = ServiceFactory.getOrderServiceInstance().findOrderById(id);
            //一个订单对应多个OrderItem
            items = ServiceFactory.getOrderItemServiceInstance().findOrderItemByOrder(order);
            //将orderItems对象添加到order对象中
            order.setOrderItems(items);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //将查询到的订单信息order添加到request作用域;
        request.setAttribute("order", order);
        //请求转发到home.jsp页面，并传递item参数，值为view；
        request.getRequestDispatcher("/admin/login/home.jsp?item=" + "view").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
