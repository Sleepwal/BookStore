package com.me.dao;

import com.me.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    // 查找所有订单
    public List<Order> selectAll() throws SQLException;
    // 根据id查找订单信息
    public Order selectById(String id) throws SQLException ;
    // 根据id删除订单
    public int delete(String id);
}
