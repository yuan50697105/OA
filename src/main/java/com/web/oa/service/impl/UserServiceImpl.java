package com.web.oa.service.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public boolean login(User user) {
        user = userDao.getByUser(user);
        return null != user;
    }

    public boolean save(User user) {
        return userDao.save(user);
    }
}
