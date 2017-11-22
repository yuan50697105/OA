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
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
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
    public User getById(Long id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User getByUserNameAndUserPassword(String userName, String userPssword) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("userName", userName));
        detachedCriteria.add(Restrictions.eq("userPassword", userPssword));
        return (User) hibernateTemplate.findByCriteria(detachedCriteria).get(0);
    }

    @Override
    public List<User> findByUserName(String userName) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("userName", userName));
        return (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public List<User> findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        return (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public Long countByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> findByUserName(String userName, int page, int size) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        if (!StringUtils.isEmpty(userName)) {
            detachedCriteria.add(Restrictions.like("userName", userName, MatchMode.ANYWHERE));
        }
        return (List<User>) hibernateTemplate.findByCriteria(detachedCriteria, page, size);
    }

    @Override
    public User getByUser(User user) {
        try {
            return hibernateTemplate.findByExample(user).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
