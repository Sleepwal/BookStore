package com.me.controller.Client;

import com.me.dao.ProductDao;
import com.me.domain.Product;
import com.me.factory.ServiceFactory;
import com.me.service.IProductService;
import com.me.service.impl.ProductServiceImpl;
import com.me.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/MenuSearchServlet")
public class MenuSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request中获取搜索参数的值
        String searchfield = request.getParameter("textfield");
        /*StringBuffer SQLStr = new StringBuffer("select * from products");
        if(!Objects.equals(searchfield, "请输入书名") && searchfield != null) {
            SQLStr.append(" where name like ").append("'%").append(searchfield).append("%'");
        }*/

        IProductService productService = ServiceFactory.getIProductServiceInstance();
        List<Product> ps = productService.showProduct(searchfield);

        /*ResultSet rs = null;
        List<Product> ps = new ArrayList<Product>();

        try {
            rs = DbUtil.executeQuery(SQLStr.toString());
            while (rs.next()){
                //循环遍历结果集rs，设置产品属性，并将产品添加到ps产品列表中
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setCategory(rs.getString(4));
                p.setPnum(rs.getInt(5));
                p.setImgurl(rs.getString(6));
                p.setDescription(rs.getString(7));

                ps.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //将产品列表ps设置到request对象的ProductList参数中,并将请求转发给ProductList.jsp页面进行后续操作。
        request.setAttribute("ProductList", ps);
        request.getRequestDispatcher("/client/login/ProductList.jsp").forward(request, response);
    }
}
