package com.me.service.impl;

import com.me.dao.NoticeDao;
import com.me.domain.Notice;
import com.me.factory.DaoFactory;
import com.me.service.INoticeService;

import java.util.List;

public class NoticeServiceImpl implements INoticeService {
    private static NoticeDao noticeDao = DaoFactory.getNoticeDAOInstance();

    @Override
    public List<Notice> showNotice() {
        return noticeDao.searchNotice();
    }

    @Override
    public boolean add(Notice notice) {
        return noticeDao.addOneNotice(notice) != 0;
    }

    @Override
    public boolean delete(String id) {
        return noticeDao.deleteOneNotice(id) != 0;
    }

    @Override
    public Notice findById(String id) {
        return noticeDao.searchById(id);
    }

    @Override
    public boolean update(Notice notice) {
        return noticeDao.updateOneNotice(notice) != 0;
    }
}
