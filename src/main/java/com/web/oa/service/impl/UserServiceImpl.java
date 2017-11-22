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

import java.util.Date;

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
        //组织注册
        organization.setRegisterTime(new Date());
        organization.setStatus("1");
        boolean flag=organizationDao.save(organization);
        if(flag){
            //用户注册
            user.setOrgId(organization.getOrgId());
            user.setCreateTime(new Date());
            user.setMark("1");
            user.setPosition("2");
            flag=userDao.save(user);
            if(flag){
                //用户信息注册
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
