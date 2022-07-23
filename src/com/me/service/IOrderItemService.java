package com.me.service;

import com.me.domain.Order;
import com.me.domain.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface IOrderItemService {
    // 根据订单id查找订单项.并将订单项中商品查找到。
    public List<OrderItem> findOrderItemByOrder(final Order order) throws SQLException;
    // 根据id删除订单项
    public boolean deleteById(String id);
}
