package com.me.dao;

import com.me.domain.Cart;

import java.util.List;

public interface CartDao {
    public List<Cart> findAllCart(String username);
    public int addOneCart(String product_id, String username);
    public int deleteOneCart(String product_id, String username);
}
