package com.web.oa.dao;

import com.web.oa.bean.Work;

import java.util.List;

public interface WorkDao {
    List<Work> getWorkListByUserId(Long userId);

    List<Work> getWorkListByUserIdAndWorkName(Long userId, String workName);

    Work getWorkById(Long workId);

    boolean update(Work work);

    boolean deleteWork(Long[] workId);

    boolean addWork(Work work);
}
