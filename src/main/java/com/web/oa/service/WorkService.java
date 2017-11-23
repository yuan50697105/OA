package com.web.oa.service;

import com.web.oa.bean.Work;

import java.util.List;

public interface WorkService {
    List<Work> list(Long userid);

    boolean save(Work work);

    Work getWork(Long id);

    boolean update(Work work);

    boolean delete(Long workId);
}
