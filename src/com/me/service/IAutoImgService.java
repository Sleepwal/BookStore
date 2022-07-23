package com.me.service;

import com.me.domain.AutoImg;
import com.me.domain.Notice;

import java.util.List;

public interface IAutoImgService {
    public List<AutoImg> showAutoImg();
    public boolean add(String img);
    public boolean delete(String id);
    public AutoImg findById(String id);
    public boolean update(AutoImg autoImg);
}
