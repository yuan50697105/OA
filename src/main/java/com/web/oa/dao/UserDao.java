package com.web.oa.dao;

import com.web.oa.bean.User;

public interface UserDao {


    User getByUser(User user);

    boolean save(User user);
}
