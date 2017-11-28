package com.web.oa.dao.impl;

import com.web.oa.bean.Contacts;
import com.web.oa.dao.ContactsDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactsDaoImpl implements ContactsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Contacts> getContactListByUserId(Long userId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Contacts.class);
        detachedCriteria.add(Restrictions.eq("userId", userId));
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }

    @Override
    public boolean saveContacts(Contacts contacts) {
        try {
            hibernateTemplate.save(contacts);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteContacts(Long contactsId) {
        try {
            hibernateTemplate.delete(hibernateTemplate.get(Contacts.class,contactsId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Contacts getContactByContactsId(Long contactsId) {
        return hibernateTemplate.get(Contacts.class,contactsId);
    }

    @Override
    public boolean updateContacts(Contacts contacts) {
        try {
            hibernateTemplate.update(contacts);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
