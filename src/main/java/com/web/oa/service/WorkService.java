package com.web.oa.service;

import com.web.oa.bean.Contacts;
import com.web.oa.bean.Work;

import java.util.List;

public interface WorkService {
    List<Work> getWorkListByUserId(Long userId);

    List<Work> getWorkListByUserIdAndWorkName(Long userId, String workName);

    Work getWorkById(Long workId);

    boolean updateWork(Work work);

    boolean deleteWork(Long workId);

    boolean addWork(Work work);

    List<Contacts> getContactsListByUserIdAndContactsName(Long userId, String contactsName);

    Contacts getContactsById(Long contactsId);

    boolean updateContacts(Contacts contacts);

    boolean deleteContacts(Long contactsId);

    boolean addContacts(Contacts contacts);
}
