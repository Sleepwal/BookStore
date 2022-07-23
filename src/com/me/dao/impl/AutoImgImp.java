package com.me.dao.impl;

import com.me.dao.AutoImgDao;
import com.me.domain.AutoImg;
import com.me.domain.Notice;
import com.me.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AutoImgImp implements AutoImgDao {
    private static QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<AutoImg> searchAutoImg() {
        String SQLStr = "select * from autoimg";

        try {
            return runner.query(SQLStr, new BeanListHandler<AutoImg>(AutoImg.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AutoImg searchById(String id) {
        String sql = "select * from autoimg where id = '" + id + "'";

        try {
            return runner.query(sql, new BeanHandler<AutoImg>(AutoImg.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addOneAutoImg(String img) {
        String SQLStr = "insert into autoimg(image) values(?)";
        try {
            return runner.update(SQLStr, img);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOneAutoImg(String id) {
        String SQLStr = "delete from autoimg where id = '" + id + "'";
        try {
            return runner.update(SQLStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateOneAutoImg(AutoImg autoImg) {
        String sql = "update autoimg set image = ? where id = ?";
        Object []params = {autoImg.getImage(), autoImg.getId()};

        try {
            return runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
