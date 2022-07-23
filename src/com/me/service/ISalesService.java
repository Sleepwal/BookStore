package com.me.service;

import com.me.domain.Sales;

import java.util.List;

public interface ISalesService {
    public List<Sales> search(String year, String month);
}
