package com.web.oa.dao;

import com.web.oa.bean.Work;

import java.util.List;

public interface WorkDao {
    boolean save(Work work);

    boolean delete(Long workId);

    boolean update(Work work);

    Work getByWorkId(Long workId);

    List<Work> listByWorkName(String workName, Long userId);

    List<Work> listByUserId(Long userId);
}
