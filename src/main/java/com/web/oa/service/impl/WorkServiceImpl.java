package com.web.oa.service.impl;

import com.web.oa.bean.Work;
import com.web.oa.dao.WorkDao;
import com.web.oa.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDao workDao;
    @Override
    public List<Work> list(Long userid) {
        return workDao.list(userid);
    }

    @Override
    public boolean save(Work work) {
        return workDao.save(work);
    }

    @Override
    public Work getWork(Long id) {
        return workDao.getById(id);
    }

    @Override
    public boolean update(Work work) {
        return workDao.update(work);
    }

    @Override
    public boolean delete(Long workId) {
       return workDao.delete(workId);
    }
}
