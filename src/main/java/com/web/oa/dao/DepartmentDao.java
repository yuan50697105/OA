package com.web.oa.dao;

import com.web.oa.bean.Department;

public interface DepartmentDao {
    boolean save(Department department);
    boolean delete(Long id);
    boolean update(Department department);
    Department getById(Long id);
}
