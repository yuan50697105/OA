package com.web.oa.service;

import com.web.oa.bean.Work;

import java.util.List;

public interface WorkService {
    List<Work> getWorkListByUserId(Long userId);

    Work getWorkByWorkId(Long workId);

    boolean updateWork(Work work);

    boolean deleteWork(Long workId);

    boolean saveWork(Work work);
}
