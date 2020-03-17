package com.bobo.service.impl;

import com.bobo.dao.UserDao;
import com.bobo.dao.impl.UserDaoImpl;
import com.bobo.entry.User;
import com.bobo.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
