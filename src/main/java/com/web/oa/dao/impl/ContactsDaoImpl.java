package com.web.oa.dao.impl;

import com.web.oa.bean.Contacts;
import com.web.oa.dao.ContactsDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactsDaoImpl implements ContactsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<Contacts> getContactsListByUserId(Long userId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select c from Contacts c where c.userId=:userId";
        Query<Contacts> query=session.createQuery(hql,Contacts.class);
        query.setParameter("userId",userId);
        return query.list();
    }

    @Override
    public List<Contacts> getContactsListByUserIdAndContactsName(Long userId, String contactsName) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select c from Contacts c where c.userId=:userId and c.name like :name";
        Query<Contacts> query=session.createQuery(hql,Contacts.class);
        query.setParameter("userId",userId);
        query.setParameter("name",contactsName);
        return query.list();
    }

    @Override
    public Contacts getContactsById(Long contactsId) {
        return hibernateTemplate.get(Contacts.class,contactsId);
    }

    @Override
    public boolean update(Contacts contacts) {
        try {
            hibernateTemplate.update(contacts);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long contactsId) {
        try {
            hibernateTemplate.delete(getContactsById(contactsId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(Contacts contacts) {
        try {
            hibernateTemplate.save(contacts);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
