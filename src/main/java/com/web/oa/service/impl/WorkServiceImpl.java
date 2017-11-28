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
        return workDao.getWorkListByUserId(userId);
    }

    @Override
    public Work getWorkByWorkId(Long workId) {
        return workDao.getWorkByWorkId(workId);
    }

    @Override
    public boolean updateWork(Work work) {
        return workDao.updateWork(work);
    }

    @Override
    public boolean deleteWork(Long workId) {
        return workDao.deleteWork(workId);
    }

    @Override
    public boolean saveWork(Work work) {
            return workDao.save(work);
    }
}
