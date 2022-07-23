package com.me.dao.impl;

import com.me.dao.OrderItemDao;
import com.me.domain.Order;
import com.me.domain.OrderItem;
import com.me.domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import com.me.util.DataSourceUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {     /*此处类似OrderDaoImpl文件中的findAllOrder方法，*/
    @Override
    public List<OrderItem> selectByOrder(Order order) throws SQLException {
        //1.创建sql
        String sql = "select * from orderitem,products where products.id = orderitem.product_id " +
                "and orderitem.order_id=? order by orderitem.product_id";

        //2.构造一个指定数据源ds的QueryRunner对象
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        //3.返回QueryRunner对象query()方法的查询结果
        return runner.query(sql, new ResultSetHandler<List<OrderItem>>() {
            public List<OrderItem> handle(ResultSet rs) throws SQLException {
                //创建订单项集合链表
                List<OrderItem> orderItems = new ArrayList<OrderItem>();

                while (rs.next()) {         //循环遍历订单项和商品信息
                    //创建订单项对象，将从数据库中查询到的订单项属性添加到订单项对象中
                    OrderItem orderItem = new OrderItem();
                    orderItem.setBuynum(rs.getInt("orderitem.buynum"));

                    //创建商品对象，将从数据库中查询到的商品属性添加到订单项对象中
                    Product product = new Product();
                    product.setId(rs.getString("products.id"));
                    product.setName(rs.getString("products.name"));
                    product.setPrice(rs.getDouble("products.price"));
                    product.setCategory(rs.getString("products.category"));
                    product.setPnum(rs.getInt("products.pnum"));
                    product.setImgurl(rs.getString("products.imgurl"));
                    product.setDescription(rs.getString("products.description"));

                    //将商品对象添加到订单项对象中
                    orderItem.setP(product);
                    //将订单项对象添加到订单项链表集合中
                    orderItems.add(orderItem);
                }

                /*返回订单项链表集合
                注意这里查询时需要参数--订单order的id。类似findOrderById方法*/
                return orderItems;
            }
        }, order.getId());

    }

    @Override
    public int delete(String id) {
        //1.创建sql
        String SQL = "delete from orderitem where order_id = ?";
        //2.构造一个指定数据源ds的QueryRunner对象
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        //3.返回QueryRunner对象update()方法的查询结果
        try {
            return runner.update(SQL, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
