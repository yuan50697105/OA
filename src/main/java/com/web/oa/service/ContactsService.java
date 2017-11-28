package com.web.oa.service;

import com.web.oa.bean.Contacts;

import java.util.List;

public interface ContactsService {
    List<Contacts> getContactsListByUserId(Long userId);

    boolean saveContacts(Contacts contacts);

    boolean deleteContacts(Long contactsId);

    Contacts getContactsByContactsId(Long contactsId);

    boolean updateContacts(Contacts contacts);
}
