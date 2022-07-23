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

@WebServlet(name = "NoticeShowAllServlet", value = "/ShowAllNotice")
public class NoticeShowAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        INoticeService noticeService = ServiceFactory.getNoticeServiceInstance();
        List<Notice> ns = noticeService.showNotice();

        request.setAttribute("ns", ns);
        request.getRequestDispatcher("/admin/login/home.jsp?item=" + "notice_list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
