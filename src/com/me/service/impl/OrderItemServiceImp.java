package com.me.service.impl;

import com.me.dao.OrderItemDao;
import com.me.domain.Order;
import com.me.domain.OrderItem;
import com.me.factory.DaoFactory;
import com.me.service.IOrderItemService;

import java.sql.SQLException;
import java.util.List;

public class OrderItemServiceImp implements IOrderItemService {
    private static OrderItemDao orderItemDao = DaoFactory.getOrderItemDAOInstance();

    @Override
    public List<OrderItem> findOrderItemByOrder(Order order) throws SQLException {
        return orderItemDao.selectByOrder(order);
    }

    @Override
    public boolean deleteById(String id) {
        return orderItemDao.delete(id) != 0;
    }
}
