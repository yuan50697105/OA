package com.web.oa.dao;

import com.web.oa.bean.Department;

import java.util.List;

public interface DepartmentDao {
    boolean save(Department department);
    boolean delete(Long departmentId);
    boolean update(Department department);
    Department getByDepartmentId(Long departmentId);
    List<Department> listByDepartmentNameAndOrgId(String departmentName,Long orgId);
}
