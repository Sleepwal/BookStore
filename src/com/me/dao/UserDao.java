package com.me.dao;

import com.me.domain.User;
import com.me.exception.UserExistException;

import java.util.List;

public interface UserDao {
    int addOneUser(User user) throws UserExistException;
    boolean selectByUsernamePwd(User u);
    List<User> findAllUser();
    int deleteOneUser(String id);
    User findOneUserByName(String name);
    int updateOneUser(User user);
    public int getTotalCount();
    public List<User> queryUsersByPage(int currentPage, int pageSize);
}
