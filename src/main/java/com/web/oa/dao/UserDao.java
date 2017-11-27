package com.web.oa.dao;

import com.web.oa.bean.User;

import java.util.List;

public interface UserDao {
    boolean save(User user);
    boolean delete(Long userId);
    boolean update(User user);
    User getByUserId(Long userId);
    User getByUser(User user);
    List<User> listByUserName(String userName);
}
