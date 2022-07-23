package com.me.controller.Admin;

import com.me.dao.SalesDao;
import com.me.domain.Sales;
import com.me.factory.DaoFactory;
import com.me.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从request中获取搜索参数year和month的值；
        调用模型层sales.java中的相关业务方法search，获取销售数量列表ps；*/
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        SalesDao salesDao = DaoFactory.getSalesDAOInstance();
        List<Sales> ps = ServiceFactory.getSalesServiceInstance().search(year, month);

        //以文件形式下载，导出到扩展名为“.csv”的文件中
        String fileName=year+"年"+month+"月销售榜单.csv";
        response.setContentType(this.getServletContext().getMimeType(fileName));
        response.setHeader("Content-Disposition", "attachement;filename="+new String(fileName.getBytes("GBK"),"iso8859-1"));
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("商品名称,销售数量");
        for (Sales arr : ps) {
            out.println(arr.getName() + "," + arr.getBuynum());
        }
        out.flush();
        out.close();
    }
}
