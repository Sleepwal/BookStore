package com.me.service;

import com.me.domain.Notice;
import com.me.domain.Product;

import java.util.List;

public interface INoticeService {
    public List<Notice> showNotice();
    public boolean add(Notice notice);
    public boolean delete(String id);
    public Notice findById(String id);
    public boolean update(Notice notice);
}
