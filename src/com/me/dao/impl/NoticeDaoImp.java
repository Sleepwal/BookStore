package com.me.dao.impl;

import com.me.dao.NoticeDao;
import com.me.domain.Notice;
import com.me.domain.Product;
import com.me.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class NoticeDaoImp implements NoticeDao {
    private static QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<Notice> searchNotice() {
        String SQLStr = "select * from notice";

        try {
            return runner.query(SQLStr, new BeanListHandler<Notice>(Notice.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Notice searchById(String id) {
        String sql = "select * from notice where n_id = '" + id + "'";

        try {
            return runner.query(sql, new BeanHandler<Notice>(Notice.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addOneNotice(Notice notice) {
        String SQLStr = "insert into notice(title, details) values(?,?)";
        Object []params = {notice.getTitle(), notice.getDetails()};
        try {
            return runner.update(SQLStr, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOneNotice(String id) {
        String SQLStr = "delete from notice where n_id = '" + id + "'";
        try {
            return runner.update(SQLStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateOneNotice(Notice notice) {
        String sql = "update notice set title = ?,details = ? where n_id = ?";
        Object []params = {notice.getTitle(), notice.getDetails(), notice.getN_id()};

        try {
            return runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
