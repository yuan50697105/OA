package com.web.oa.dao;

import com.web.oa.bean.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    void delete(Long id);
    void update(User user);
    User getById(Long id);
    User getByUserid();
}
