package com.me.dao.impl;

import com.me.dao.SalesDao;
import com.me.domain.Sales;
import com.me.util.DataSourceUtils;
import com.me.util.DbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDaoImp implements SalesDao {
    @Override
    public List<Sales> selectByYearMonth(String year, String month) {
        String sql = "SELECT products.name,SUM(orderitem.buynum) totalsalnum "
                + "FROM orders,products,orderItem "
                + "WHERE orders.id=orderItem.order_id "
                + "AND products.id=orderItem.product_id AND orders.paystate=1 "
                + "AND year(ordertime)= "+year+" and month(ordertime)="+month+" "
                + "GROUP BY products.name ORDER BY totalsalnum DESC";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        try {
            return runner.query(sql, new ResultSetHandler<List<Sales>>() {
                @Override
                public List<Sales> handle(ResultSet resultSet) throws SQLException {
                    List<Sales> ps = new ArrayList<Sales>();

                    while (resultSet.next()) {
                        Sales sales = new Sales();
                        sales.setName(resultSet.getString(1));
                        sales.setBuynum(resultSet.getInt(2));

                        ps.add(sales);
                    }
                    return ps;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
