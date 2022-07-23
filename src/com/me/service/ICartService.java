package com.me.service;

import com.me.domain.Cart;

import java.util.List;

public interface ICartService {
    public List<Cart> showAll(String username);
    public boolean add(String product_id, String username);
    public boolean delete(String product_id, String username);
}
