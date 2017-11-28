package com.web.oa.dao;

import com.web.oa.bean.Contacts;

import java.util.List;

public interface ContactsDao {
    List<Contacts> getContactListByUserId(Long userId);

    boolean saveContacts(Contacts contacts);

    boolean deleteContacts(Long contactsId);

    Contacts getContactByContactsId(Long contactsId);

    boolean updateContacts(Contacts contacts);
}
