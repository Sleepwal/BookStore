package com.me.service.impl;

import com.me.dao.OrderDao;
import com.me.domain.Order;
import com.me.factory.DaoFactory;
import com.me.service.IOrderService;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImp implements IOrderService {
    private static OrderDao orderDao = DaoFactory.getOrderDAOInstance();

    // 查找所有订单
    @Override
    public List<Order> findAllOrder() throws SQLException {
        return orderDao.selectAll();
    }

    // 根据id查找订单信息
    @Override
    public Order findOrderById(String id) throws SQLException {
        return orderDao.selectById(id);
    }

    // 根据id删除订单
    @Override
    public boolean deleteById(String id) {
        return orderDao.delete(id) != 0;
    }
}
