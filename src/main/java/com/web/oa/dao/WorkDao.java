package com.web.oa.dao;

import com.web.oa.bean.Work;
import org.springframework.util.StringUtils;

import java.util.List;

public interface WorkDao {
    /**
     * 获取个人工作计划
     * @param userid
     * @return
     */
    List<Work> list(Long userid);

    /**
     * 保存工作计划
     * @param work
     * @return
     */
    boolean save(Work work);

    /**
     * 显示一个work的信息
     * @param id
     * @return
     */
    Work getById(Long id);

    boolean update(Work work);
}
