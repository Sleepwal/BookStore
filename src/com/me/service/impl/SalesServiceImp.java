package com.me.service.impl;

import com.me.domain.Sales;
import com.me.factory.DaoFactory;
import com.me.service.ISalesService;

import java.util.List;

public class SalesServiceImp implements ISalesService {
    @Override
    public List<Sales> search(String year, String month) {
        return DaoFactory.getSalesDAOInstance().selectByYearMonth(year, month);
    }
}
