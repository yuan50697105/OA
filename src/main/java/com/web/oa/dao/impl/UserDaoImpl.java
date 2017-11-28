package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(User user) {
        try {
            hibernateTemplate.save(user);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByUser(User user) {
        List list=hibernateTemplate.findByExample(user);
        if(list.isEmpty()){
            return null;
        }else {
            return (User) list.get(0);
        }
    }
}
