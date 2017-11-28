package com.web.oa.dao;

import com.web.oa.bean.User;

public interface UserDao {
    boolean save(User user);

    User getUserByUser(User user);

}
