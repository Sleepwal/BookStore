package com.me.service.impl;

import com.me.dao.CartDao;
import com.me.domain.Cart;
import com.me.factory.DaoFactory;
import com.me.service.ICartService;

import java.util.List;

public class CartServiceImp implements ICartService {
    @Override
    public List<Cart> showAll(String username) {
        CartDao cartDao = DaoFactory.getCartDAOInstance();
        return cartDao.findAllCart(username);
    }

    @Override
    public boolean add(String product_id, String username) {
        CartDao cartDao = DaoFactory.getCartDAOInstance();
        return cartDao.addOneCart(product_id, username) != 0;
    }

    @Override
    public boolean delete(String product_id, String username) {
        CartDao cartDao = DaoFactory.getCartDAOInstance();
        return cartDao.deleteOneCart(product_id, username) != 0;
    }
}
