package com.me.dao;

import com.me.domain.Sales;

import java.util.List;

public interface SalesDao {
    public List<Sales> selectByYearMonth(String year, String month);
}
