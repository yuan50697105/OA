package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.dao.UserDataDao;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
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
    public boolean delete(Long userId) {
        try {
            hibernateTemplate.delete(getByUserId(userId));
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
    public UserData getByUserId(Long userId) {
        return hibernateTemplate.get(UserData.class,userId);
    }

    @Override
    public List<UserData> listByUserName(String userName) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(UserData.class);
        if(!StringUtils.isEmpty(userName)){
            DetachedCriteria user=DetachedCriteria.forClass(User.class);
            user.add(Restrictions.like("userName",userName, MatchMode.ANYWHERE));
            user.setProjection(Projections.property("userId"));
            detachedCriteria.add(Property.forName("userId").in(user));
        }
        boolean isEmpty=hibernateTemplate.findByCriteria(detachedCriteria).isEmpty();
        if(isEmpty){
            return null;
        }else {
            return (List<UserData>) hibernateTemplate.findByCriteria(detachedCriteria);
        }
    }
}
