package com.me.dao.impl;

import com.me.dao.ProductDao;
import com.me.domain.Product;
import com.me.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProductDaoImp implements ProductDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<Product> searchProduct(String searchfield){
        StringBuffer SQLStr = new StringBuffer("select * from products");
        if(!Objects.equals(searchfield, "请输入书名") && searchfield != null) {
            SQLStr.append(" where name like ").append("'%").append(searchfield).append("%'");
        }

        try {
            return runner.query(SQLStr.toString(), new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Product searchById(String id) {
        String sql = "select * from products where id = '" + id + "'";

        try {
            return runner.query(sql, new BeanHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addOneProduct(Product product) {
        String SQLStr = "insert into products values(?,?,?,?,?,?,?)";
        Object []params = {UUID.randomUUID().toString(), product.getName(), product.getPrice(),
                product.getCategory(), product.getPnum(), product.getImgurl(), product.getDescription()};
        try {
            return runner.update(SQLStr, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOneProduct(String id) {
        String SQLStr = "delete from products where id = '" + id + "'";
        try {
            return runner.update(SQLStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateOneProduct(Product p) {
        String sql = "update products set name = ?,price = ?, category = ?,pnum = ?,imgurl = ?,description = ? where id = ?";
        Object []params = { p.getName(),p.getPrice(), p.getCategory(), p.getPnum(), p.getImgurl(),
                p.getDescription(), p.getId()};

        try {
            return runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getTotalCount() {//查询总数据量
        String sql = "select * from products";
        List<Product> product = new ArrayList<Product>();
        try {
            product = runner.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product.size();
    }

    @Override
    public List<Product> queryUsersByPage(int currentPage, int pageSize) {
        //从数据表products中的第M条记录开始检索N条记录
        String sql = "select * from products order by name limit ? , ? ";
        Object[] params = {currentPage*pageSize,pageSize};
        List<Product> product = new ArrayList<Product>();

        try {
            product = runner.query(sql, new BeanListHandler<Product>(Product.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
