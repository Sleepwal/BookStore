package com.me.controller.Admin;

import com.me.factory.ServiceFactory;
import com.me.service.IProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Admin_DelProductServlet", value = "/DelProductServlet")
public class ProductDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductService productService = ServiceFactory.getIProductServiceInstance();
        productService.delete(request.getParameter("id"));

        request.getRequestDispatcher("/FindProductServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
