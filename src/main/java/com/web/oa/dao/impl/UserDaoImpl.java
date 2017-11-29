package com.web.oa.dao.impl;

import com.web.oa.bean.User;
import com.web.oa.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
    public User login(User user) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select u from User u where u.userName=:userName and u.userPassword=:userPassword";
        Query<User> query=session.createQuery(hql,User.class);
        query.setParameter("userName",user.getUserName());
        query.setParameter("userPassword",user.getUserPassword());
        return query.uniqueResult();
    }
}
