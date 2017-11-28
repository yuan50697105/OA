package com.web.oa.service.impl;

import com.web.oa.bean.Contacts;
import com.web.oa.dao.ContactsDao;
import com.web.oa.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsDao contactsDao;
    @Override
    public List<Contacts> getContactsListByUserId(Long userId) {
        return contactsDao.getContactListByUserId(userId);
    }

    @Override
    public boolean saveContacts(Contacts contacts) {
        return contactsDao.saveContacts(contacts);
    }

    @Override
    public boolean deleteContacts(Long contactsId) {
        return contactsDao.deleteContacts(contactsId);
    }

    @Override
    public Contacts getContactsByContactsId(Long contactsId) {
        return contactsDao.getContactByContactsId(contactsId);
    }

    @Override
    public boolean updateContacts(Contacts contacts) {
        return contactsDao.updateContacts(contacts);
    }
}
