package com.web.oa.dao;

import com.web.oa.bean.DepartmentMembers;

public interface DepartmentMembersDao {
    boolean save(DepartmentMembers departmentMembers);
    boolean delete(Long id);
    boolean update(DepartmentMembers departmentMembers);
    DepartmentMembers getById(Long id);
}
