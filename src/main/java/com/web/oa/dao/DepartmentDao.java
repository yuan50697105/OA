package com.web.oa.dao;

import com.web.oa.bean.Department;

import java.util.List;

public interface DepartmentDao {
    boolean save(Department department);

    boolean delete(long id);

    boolean update(Department department);

    Department getById(long id);

    List<Department> findAll();

    List<Department> findByDepartmentName(String departmentName);

    List<Department> findByDepartmentName(String departmentName, int page, int size);

    Long countByDepartmentName(String departmentName);
}
