package com.me.service.impl;

import com.me.dao.AutoImgDao;
import com.me.domain.AutoImg;
import com.me.domain.Notice;
import com.me.factory.DaoFactory;
import com.me.service.IAutoImgService;

import java.util.List;

public class AutoImgServiceImp implements IAutoImgService {
    private static AutoImgDao autoImgDao = DaoFactory.getAutoImgDAOInstance();

    @Override
    public List<AutoImg> showAutoImg() {
        return autoImgDao.searchAutoImg();
    }

    @Override
    public boolean add(String img) {
        return autoImgDao.addOneAutoImg(img) != 0;
    }

    @Override
    public boolean delete(String id) {
        return autoImgDao.deleteOneAutoImg(id) != 0;
    }

    @Override
    public AutoImg findById(String id) {
        return autoImgDao.searchById(id);
    }

    @Override
    public boolean update(AutoImg autoImg) {
        return autoImgDao.updateOneAutoImg(autoImg) != 0;
    }
}
