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
    public List<Work> getWorkListByUserId(Long userId) {
        return workDao.listByUserId(userId);
    }

    @Override
    public Work getWork(Long workId) {
        return workDao.getByWorkId(workId);
    }

    @Override
    public List<Work> getWorkListByName(String workName, Long userId) {
        return workDao.listByWorkName(workName, userId);
    }

    @Override
    public boolean save(Work work) {
        return workDao.save(work);
    }

    @Override
    public boolean delete(Long workId) {
        return workDao.delete(workId);
    }

    @Override
    public boolean update(Work work) {
        return workDao.update(work);
    }
}
