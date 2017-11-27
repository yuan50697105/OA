package com.web.oa.dao;

import com.web.oa.bean.UserData;

import java.util.List;

public interface UserDataDao {
    boolean save(UserData userData);
    boolean delete(Long userId);
    boolean update(UserData userData);
    UserData getByUserId(Long userId);
    List<UserData> listByUserName(String userName);
}
