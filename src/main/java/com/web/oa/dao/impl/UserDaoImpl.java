package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public User save(User user) {
        return null;
    }

    public void delete(Long id) {

    }

    public void update(User user) {

    }

    public User getById(Long id) {
        return null;
    }

    public User getByUserid() {
        return null;
    }
}
