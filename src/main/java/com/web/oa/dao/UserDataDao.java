package com.web.oa.dao;

import com.web.oa.bean.UserData;

public interface UserDataDao {
    boolean save(UserData userData);
    boolean delete(Long id);
    boolean update(UserData userData);
    UserData getById(Long id);
}
