package com.purchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchase.dao.UserDao;
import com.purchase.entity.User;

@Service
public class UserServiceImpl implements UserServiceInterface {
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

}
