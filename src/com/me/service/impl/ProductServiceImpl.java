package com.me.service.impl;

import com.me.dao.ProductDao;
import com.me.domain.Product;
import com.me.factory.DaoFactory;
import com.me.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Override
    public List<Product> showProduct(String searchfield) {
        ProductDao productDao = DaoFactory.getProductDAOInstance();
        return productDao.searchProduct(searchfield);
    }

    @Override
    public boolean addProduct(Product product) {
        ProductDao productDao = DaoFactory.getProductDAOInstance();
        return productDao.addOneProduct(product) != 0;
    }

    @Override
    public boolean delete(String id) {
        ProductDao productDao = DaoFactory.getProductDAOInstance();
        return productDao.deleteOneProduct(id) != 0;
    }

    @Override
    public Product findById(String id) {
        ProductDao productDao = DaoFactory.getProductDAOInstance();
        return productDao.searchById(id);
    }

    @Override
    public boolean update(Product p) {
        ProductDao productDao = DaoFactory.getProductDAOInstance();
        return productDao.updateOneProduct(p) != 0;
    }
}
