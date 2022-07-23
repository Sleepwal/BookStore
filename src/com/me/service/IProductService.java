package com.me.service;

import com.me.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> showProduct(String searchfield);
    public boolean addProduct(Product product);
    public boolean delete(String id);
    public Product findById(String id);
    public boolean update(Product p);
}
