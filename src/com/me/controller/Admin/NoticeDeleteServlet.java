package com.me.controller.Admin;

import com.me.factory.ServiceFactory;
import com.me.service.INoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NoticeDeleteServlet", value = "/DeleteNotice")
public class NoticeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        INoticeService noticeService = ServiceFactory.getNoticeServiceInstance();
        noticeService.delete(id);

        request.getRequestDispatcher("/ShowAllNotice").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
