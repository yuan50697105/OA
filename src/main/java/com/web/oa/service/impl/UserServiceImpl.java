package com.web.oa.service.impl;

import com.web.oa.bean.Menu;
import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.commons.WebCommons;
import com.web.oa.dao.MenuDao;
import com.web.oa.dao.OrgDao;
import com.web.oa.dao.UserDao;
import com.web.oa.dao.UserDataDao;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private OrgDao orgDao;
    @Autowired
    private MenuDao menuDao;
    @Override
    public Map<String, Object> registor(User user, UserData userData, Organization organization) {
        Map<String,Object> map=new HashMap<>();
        boolean flag=orgDao.save(organization);
        if(flag){
            map.put(WebCommons.ORG,organization);
            user.setOrgId(organization.getOrgId());
            flag=userDao.save(user);
            if(flag){
                map.put(WebCommons.USER,user);
                userData.setUserId(user.getUserId());
                flag=userDataDao.save(userData);
                if (flag) {
                    map.put(WebCommons.USER_DATA, userData);
                }
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> login(User user) {
        user = userDao.login(user);
        if (null != user) {
            Map<String,Object> map=new HashMap<>();
            map.put(WebCommons.USER,user);
            Organization organization=orgDao.getOrgById(user.getOrgId());
            map.put(WebCommons.ORG,organization);
            UserData userData=userDataDao.getDataByUserId(user.getUserId());
            map.put(WebCommons.USER_DATA,userData);
            List<Menu> menuList=menuDao.getMainMenuByUserId(user.getUserId());
            map.put(WebCommons.MENU_LIST,menuList);
            return map;
        } else {
            return null;
        }
    }
}
