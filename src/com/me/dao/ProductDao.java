package com.me.dao;

import com.me.domain.Product;
import java.util.List;

public interface ProductDao {
    public List<Product> searchProduct(String searchfield);
    public Product searchById(String id);
    public int addOneProduct(Product product);
    public int deleteOneProduct(String id);
    public int updateOneProduct(Product p);
    public int getTotalCount();
    public List<Product> queryUsersByPage(int currentPage, int pageSize);
}
