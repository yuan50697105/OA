package com.web.oa.service;

import com.web.oa.bean.Work;

import java.util.List;

public interface WorkService {
    List<Work> getWorkListByUserId(Long userId);

    Work getWork(Long workId);

    List<Work> getWorkListByName(String workName, Long userId);

    boolean save(Work work);

    boolean delete(Long workId);

    boolean update(Work work);
}
