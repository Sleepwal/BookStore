package com.me.controller.Admin;

import com.me.domain.AutoImg;
import com.me.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AutoImageShowAllServlet", value = "/ShowAllAutoImage")
public class AutoImageShowAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AutoImg> as = ServiceFactory.getAutoImgServiceInstance().showAutoImg();

        request.setAttribute("as", as);
        request.getRequestDispatcher("/admin/login/home.jsp?item=" + "autoimg_list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
