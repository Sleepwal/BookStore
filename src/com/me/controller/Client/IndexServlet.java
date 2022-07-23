package com.me.controller.Client;

import com.me.domain.AutoImg;
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

@WebServlet(name = "ClientNoticeFindByIdServlet", value = "/ClientFindNoticeById")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = "1";
        String id = "8";

        INoticeService noticeService = ServiceFactory.getNoticeServiceInstance();
        Notice notice = noticeService.findById(id);

        List<AutoImg> as = ServiceFactory.getAutoImgServiceInstance().showAutoImg();

        request.setAttribute("n", notice);
        request.setAttribute("as", as);
        request.getRequestDispatcher("/client/login/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
