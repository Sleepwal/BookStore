package com.me.dao.impl;

import com.me.dao.CartDao;
import com.me.domain.Cart;
import com.me.domain.Product;
import com.me.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImp implements CartDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<Cart> findAllCart(String username) {
        String sql = "select * from cart, products where cart.product_id = products.id " +
                "and cart.user_name = '" + username + "'";

        try {
            return runner.query(sql, new ResultSetHandler<List<Cart>>() {
                @Override
                public List<Cart> handle(ResultSet resultSet) throws SQLException {
                    List<Cart> cs = new ArrayList<Cart>();

                    while(resultSet.next()){
                        Cart cart = new Cart();
                        cart.setNum(resultSet.getInt("cart.num"));
                        cart.setUsername(resultSet.getString("cart.user_name"));

                        Product p = new Product();
                        p.setId(resultSet.getString("products.id"));
                        p.setName(resultSet.getString("products.name"));
                        p.setPrice(resultSet.getDouble("products.price"));
                        p.setPnum(resultSet.getInt("products.pnum"));
                        cart.setP(p);

                        cs.add(cart);
                    }

                    return cs;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addOneCart(String product_id, String username) {
        String sql = "insert into cart(user_name,product_id,num) values('" + username + "','" + product_id + "', 1)";

        try {
            return runner.update(sql);
        } catch (SQLException e) {
            sql = "update cart set num = num + 1 where product_id = '" + product_id
                    + "' and user_name = '" + username + "'";
            try {
                return runner.update(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return 0;
            }
        }
    }

    @Override
    public int deleteOneCart(String product_id, String username) {
        String sql = "delete from cart where product_id = '" + product_id + "' and user_name = '" + username + "'";

        try {
            return runner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
