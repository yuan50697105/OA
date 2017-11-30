package com.web.oa.service.impl;

import com.web.oa.bean.Contacts;
import com.web.oa.bean.Work;
import com.web.oa.dao.ContactsDao;
import com.web.oa.dao.WorkDao;
import com.web.oa.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDao workDao;
    @Autowired
    private ContactsDao contactsDao;
    @Override
    public List<Work> getWorkListByUserId(Long userId) {
        return workDao.getWorkListByUserId(userId);
    }

    @Override
    public List<Work> getWorkListByUserIdAndWorkName(Long userId, String workName) {
        if (StringUtils.isEmpty(workName)) {
            return workDao.getWorkListByUserId(userId);
        } else {
            return workDao.getWorkListByUserIdAndWorkName(userId, workName);
        }
    }

    @Override
    public Work getWorkById(Long workId) {
        return workDao.getWorkById(workId);
    }

    @Override
    public boolean updateWork(Work work) {
        return workDao.update(work);
    }

    @Override
    public boolean deleteWork(Long[] workId) {
        return workDao.deleteWork(workId);
    }

    @Override
    public boolean addWork(Work work) {
        return workDao.addWork(work);
    }

    @Override
    public List<Contacts> getContactsListByUserIdAndContactsName(Long userId, String contactsName) {
        if(StringUtils.isEmpty(contactsName)){
            return contactsDao.getContactsListByUserId(userId);
        }else {
            return contactsDao.getContactsListByUserIdAndContactsName(userId,contactsName);
        }
    }

    @Override
    public Contacts getContactsById(Long contactsId) {
        return contactsDao.getContactsById(contactsId);
    }

    @Override
    public boolean updateContacts(Contacts contacts) {
        return contactsDao.update(contacts);
    }

    @Override
    public boolean deleteContacts(Long contactsId) {
        return contactsDao.delete(contactsId);
    }

    @Override
    public boolean addContacts(Contacts contacts) {
        return contactsDao.save(contacts);
    }
}
