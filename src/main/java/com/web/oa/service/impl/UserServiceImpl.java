package com.web.oa.service.impl;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.commons.WebCommons;
import com.web.oa.dao.OrganizationDao;
import com.web.oa.dao.UserDao;
import com.web.oa.dao.UserDataDao;
import com.web.oa.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Override
    public Map<String, Object> registor(User user, UserData userData, Organization organization) {
        Map<String,Object> map=new HashMap<>();
        boolean flag=organizationDao.save(organization);
        if(flag){
            user.setOrgId(organization.getOrgId());
            map.put(WebCommons.ORG,organization);
            flag=userDao.save(user);
            if(flag){
                userData.setUserId(user.getUserId());
                map.put(WebCommons.USER,user);
                flag=userDataDao.save(userData);
                if(flag){
                    map.put(WebCommons.USER_DATA,userData);
                }
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> login(User user) {
        user=userDao.getByUser(user);
        if(null!=user){
            Map<String,Object> map=new HashMap<>();
            map.put(WebCommons.USER,user);
            Organization organization=organizationDao.getByOrgId(user.getOrgId());
            map.put(WebCommons.ORG, organization);
            UserData userData=userDataDao.getByUserId(user.getUserId());
            map.put(WebCommons.USER_DATA,userData);
            return map;
        }else{
            return null;
        }

    }
}
