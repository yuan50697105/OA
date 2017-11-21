package com.web.oa.dao.impl;

import com.web.oa.bean.UserData;
import com.web.oa.dao.UserDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataDaoImpl implements UserDataDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(UserData userData) {
        try {
            hibernateTemplate.save(userData);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(UserData userData) {
        try {
            hibernateTemplate.update(userData);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserData getById(Long id) {
       return hibernateTemplate.get(UserData.class,id);
    }
}
