package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long userId) {
        try {
            hibernateTemplate.delete(getByUserId(userId));
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        try {
            hibernateTemplate.update(user);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getByUserId(Long userId) {
        return hibernateTemplate.get(User.class, userId);
    }

    @Override
    public User getByUser(User user) {
        boolean isEmpty = hibernateTemplate.findByExample(user).isEmpty();
        if (isEmpty) {
            return null;
        } else {
            return hibernateTemplate.findByExample(user).get(0);
        }
    }

    @Override
    public List<User> listByUserName(String userName) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        if (!StringUtils.isEmpty(userName)) {
            detachedCriteria.add(Restrictions.like("userName", userName, MatchMode.ANYWHERE));
        }
        boolean isEmpty = hibernateTemplate.findByCriteria(detachedCriteria).isEmpty();
        if (isEmpty) {
            return null;
        } else {
            return (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
        }
    }
}
