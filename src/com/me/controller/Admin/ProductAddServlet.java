package com.me.controller.Admin;

import com.me.domain.Product;
import com.me.factory.ServiceFactory;
import com.me.service.IProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.Integer;
import java.lang.Double;

@WebServlet(name = "Admin_AddProductServlet", value = "/AddProductServlet")
public class ProductAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductService productService = ServiceFactory.getIProductServiceInstance();
        Product p = new Product();
        p.setName(request.getParameter("name"));
        p.setPrice(Double.parseDouble("".equals(request.getParameter("price")) ? "0.00" : request.getParameter("price")));
        p.setPnum(Integer.parseInt("".equals(request.getParameter("pnum"))?"0":request.getParameter("pnum")));
        /*p.setPnum(Integer.parseInt(request.getParameter("pnum")));*/
        p.setCategory(request.getParameter("category"));
        p.setImgurl(request.getParameter("imgurl"));
        p.setDescription(request.getParameter("description"));

        productService.addProduct(p);
        //response.sendRedirect("/FindProductServlet");
        request.getRequestDispatcher("/FindProductServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
