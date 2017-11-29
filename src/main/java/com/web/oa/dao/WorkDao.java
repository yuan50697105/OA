package com.web.oa.dao;

import com.web.oa.bean.Work;

import java.util.List;

public interface WorkDao {
    List<Work> getWorkListByUserId(Long userId);

    Work getWorkByWorkId(Long workId);

    boolean updateWork(Work work);

    boolean save(Work work);

    boolean deleteWork(Long workId);

    List<Work> getWorkListByUserIdAndWorkName(Long userId, String workName);
}
