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

@WebServlet(name = "NoticeUpdateServlet" ,value = "/UpdateNotice")
public class NoticeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String details = request.getParameter("details");
        Notice notice = new Notice(title, details);
        notice.setN_id(Integer.parseInt(id==null ? "0" : id));

        INoticeService noticeService = ServiceFactory.getNoticeServiceInstance();
        noticeService.update(notice);

        request.getRequestDispatcher("/ShowAllNotice").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
