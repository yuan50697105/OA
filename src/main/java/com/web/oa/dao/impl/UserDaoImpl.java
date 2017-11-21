package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public User getByUser(User user) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("userName", user.getUserName()));
        detachedCriteria.add(Restrictions.eq("userPassword", user.getUserPassword()));
        return (User) hibernateTemplate.findByCriteria(detachedCriteria).get(0);
    }

    public boolean save(User user) {
        try {
            hibernateTemplate.save(user);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}
