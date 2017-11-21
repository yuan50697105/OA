package com.web.oa.service.impl;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.dao.OrganizationDao;
import com.web.oa.dao.UserDao;
import com.web.oa.dao.UserDataDao;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private UserDao userDao;
    @Override
    public boolean save(User user, UserData userData, Organization organization) {
        boolean flag=organizationDao.save(organization);
        if(flag){
            user.setOrgId(organization.getOrgId());
            flag=userDao.save(user);
            if(flag){
                userData.setUserId(user.getUserId());
                flag=userDataDao.save(userData);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }
}
