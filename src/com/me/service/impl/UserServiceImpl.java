package com.me.service.impl;

import com.me.dao.UserDao;
import com.me.domain.User;
import com.me.exception.UserExistException;
import com.me.factory.DaoFactory;
import com.me.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public void login(User u) throws UserExistException {
        boolean state;
        state = DaoFactory.getUserDAOInstance().selectByUsernamePwd(u);
        if (!state) {
            throw new UserExistException("用户名密码不正确或用户类型不正确！");
        }
    }

    @Override
    public void register(User user) throws UserExistException {
        DaoFactory.getUserDAOInstance().addOneUser(user);
    }

    @Override
    public List<User> showUser() {
        UserDao userDao = DaoFactory.getUserDAOInstance();
        return userDao.findAllUser();
    }

    @Override
    public boolean delete(String id) {
        UserDao userDao = DaoFactory.getUserDAOInstance();
        return userDao.deleteOneUser(id) != 0;
    }

    @Override
    public User findByName(String name) {
        UserDao userDao = DaoFactory.getUserDAOInstance();
        return userDao.findOneUserByName(name);
    }

    @Override
    public boolean update(User user) {
        UserDao userDao = DaoFactory.getUserDAOInstance();
        return userDao.updateOneUser(user) != 0;
    }

}
