package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
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
        String hql = "select u from User u where u.userName=:name and u.userPassword =:pwd";
        return (User) hibernateTemplate.find(hql, new String[]{"name", "pwsd"}, new Object[]{userName, userPssword}).get(0);
    }

    public User getByUserNameAndUserPassword2(String userName, String userPassword) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("userName", userName));
        detachedCriteria.add(Restrictions.eq("userPassword", userPassword));
        return (User) hibernateTemplate.findByCriteria(detachedCriteria).get(0);
    }

    @Override
    public List<User> findByUserName(String userName) {

        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Long countByUserName(String userName) {
        return null;
    }
}
