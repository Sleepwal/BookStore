package com.me.controller.Admin;

import com.me.domain.Notice;
import com.me.factory.ServiceFactory;
import com.me.service.INoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoticeFindByIdServlet", value = "/FindNoticeById")
public class NoticeFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        INoticeService noticeService = ServiceFactory.getNoticeServiceInstance();
        Notice notice = noticeService.findById(id);

        request.setAttribute("n", notice);
        request.getRequestDispatcher("/admin/login/home.jsp?item=" + "notice_edit").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
