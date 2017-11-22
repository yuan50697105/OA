package com.web.oa.service;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;

import java.util.Map;

public interface UserService {
    boolean save(User user, UserData userData, Organization organization);

    Map<String,Object> reg(User user, UserData userData, Organization organization);
}
