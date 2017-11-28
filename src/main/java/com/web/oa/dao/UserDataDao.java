package com.web.oa.dao;

import com.web.oa.bean.UserData;

public interface UserDataDao {
    boolean save(UserData userData);

    UserData getUserDataByUserId(Long userId);
}
