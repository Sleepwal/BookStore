package com.me.service;

import com.me.domain.User;
import com.me.exception.UserExistException;

import java.util.List;

public interface IUserService {
	/**
	 * 登录
	 * 
	 * @param u -- 用户
	 * 
	 * @return true：成功；false：失败
	 */
	public void login(User u) throws UserExistException;

	/**
	 * 注册
	 * 
	 * @param user -- 用户
	 * 
	 * @return boolean -- 标志，true：注册成功；false：注册失败
	 * @throws UserExistException 
	 */
	void register(User user) throws UserExistException;

	List<User> showUser();

	boolean delete(String id);

	User findByName(String name);

	boolean update(User user);
}
