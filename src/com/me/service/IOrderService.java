package com.me.service;

import com.me.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    // 查找所有订单
    public List<Order> findAllOrder() throws SQLException;
    // 根据id查找订单信息
    public Order findOrderById(String id) throws SQLException ;
    // 根据id删除订单
    public boolean deleteById(String id);
}
