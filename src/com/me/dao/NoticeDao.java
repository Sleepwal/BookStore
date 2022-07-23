package com.me.dao;

import com.me.domain.Notice;

import java.util.List;

public interface NoticeDao {
    public List<Notice> searchNotice();
    public Notice searchById(String id);
    public int addOneNotice(Notice notice);
    public int deleteOneNotice(String id);
    public int updateOneNotice(Notice notice);
}
