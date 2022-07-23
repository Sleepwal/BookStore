package com.me.dao;

import com.me.domain.AutoImg;
import com.me.domain.Notice;

import java.util.List;

public interface AutoImgDao {
    public List<AutoImg> searchAutoImg();
    public AutoImg searchById(String id);
    public int addOneAutoImg(String img);
    public int deleteOneAutoImg(String id);
    public int updateOneAutoImg(AutoImg autoImg);
}
