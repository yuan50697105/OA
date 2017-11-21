package com.web.oa.service;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;

public interface UserService {
    boolean save(User user, UserData userData, Organization organization);
}
