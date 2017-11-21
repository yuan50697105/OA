package com.web.oa.service;

import com.web.oa.bean.User;

public interface UserService {
    boolean login(User user);

    boolean save(User user);
}
