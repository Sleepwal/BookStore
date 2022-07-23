package com.me.dao.impl;

import com.me.dao.UserDao;
import com.me.domain.User;
import com.me.exception.UserExistException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.me.util.DataSourceUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public int addOneUser(User user) throws UserExistException {
        String sql = "insert into user(username,password,gender,email,telephone,introduce) values (?,?,?,?,?,?)";
        String username = user.getUsername();
        Object[] params = { username, user.getPassword(), user.getGender(), user.getEmail(),
                user.getTelephone(), user.getIntroduce() };

        try{
            return queryRunner.update(sql, params);
        }
        catch (SQLException e){
            if (e.getMessage().contains("Duplicate entry '" + username + "' for key 'PRIMARY'")) {
                throw new UserExistException("注册失败，用户'" + username + "'已存在！");
            } else {
                throw new UserExistException("注册失败，原因不明！");
            }
        }
    }

    @Override
    public boolean selectByUsernamePwd(User u) {
        String sql = "select * from user where username = ? and password = ? and role = ?";
        Object param[] = { u.getUsername(), u.getPassword(), u.getRole() };
        User user = null;
        try {
           user = queryRunner.query(sql, new BeanHandler<User>(User.class), param);
        }catch (Exception e){
            return false;
        }
        return user != null;
    }

    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";

        try {
            return queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deleteOneUser(String id) {
        String sql = "delete from user where id = ?";
        try {
            return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public User findOneUserByName(String name) {
        String sql = "select * from user where username = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<User>(User.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateOneUser(User user) {
        String sql = "update user set username = ?,password = ?, gender = ?,email = ?,telephone = ?,introduce = ? where id = ?";
        Object []params = { user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(),
        user.getTelephone(), user.getIntroduce(), user.getId() };

        try {
            return queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getTotalCount() {//查询总数据量
        String sql = "select * from user" ;
        List<User> users = new ArrayList<User>();
        try {
            users=queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users.size();
    }

    @Override
    public List<User> queryUsersByPage(int currentPage, int pageSize) {
        //从数据表tb_users中的第M条记录开始检索N条记录
        String sql = "select * from user order by username limit ? , ? ";
        Object[] params = {currentPage*pageSize,pageSize};
        List<User> users = new ArrayList<>();
        try {
            users=queryRunner.query(sql, new BeanListHandler<User>(User.class), params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }

}
