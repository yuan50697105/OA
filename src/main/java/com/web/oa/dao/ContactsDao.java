package com.web.oa.dao;

import com.web.oa.bean.Contacts;

import java.util.List;

public interface ContactsDao {
    List<Contacts> getContactsListByUserId(Long userId);

    List<Contacts> getContactsListByUserIdAndContactsName(Long userId, String contactsName);

    Contacts getContactsById(Long contactsId);


    boolean update(Contacts contacts);

    boolean delete(Long contactsId);

    boolean save(Contacts contacts);
}
