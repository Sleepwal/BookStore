package com.me.controller.Admin;

import com.me.dao.ProductDao;
import com.me.domain.Product;
import com.me.factory.DaoFactory;
import com.me.util.PageHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin_FindProductServlet", value = "/FindProductServlet")
public class ProductFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPage");
        //默认显示首页
        if(curPage == null) {
            curPage = "0" ;
        }

        int currentPage = Integer.parseInt( curPage );
        currentPage = Math.max(currentPage, 0);
        PageHelp<Product> pageHelp = new PageHelp<>();
        pageHelp.setCurrentPage(currentPage);

        ProductDao productDao = DaoFactory.getProductDAOInstance();
        int totalCount = productDao.getTotalCount();
        pageHelp.setTotalCount(totalCount);

        int pageSize = 2;
        pageHelp.setPageSize(pageSize);

        if(currentPage > pageHelp.getTotalPage() - 1){
            currentPage = pageHelp.getTotalPage() - 1;
            pageHelp.setCurrentPage(pageHelp.getTotalPage() - 1);
        }


        List<Product> products = productDao.queryUsersByPage(currentPage, pageSize);
        pageHelp.setList(products);

        request.setAttribute("pageHelp", pageHelp);

        /*IProductService productService = ServiceFactory.getIProductServiceInstance();
        List<Product> ps =  productService.showProduct("");

        request.setAttribute("ps", ps);
        */
        request.getRequestDispatcher("/admin/login/home.jsp?item=" + "product_list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
