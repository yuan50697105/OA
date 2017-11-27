package com.web.oa.dao;

import com.web.oa.bean.DepartmentMembers;

import java.util.List;

public interface DepartmentMemberDao {
    boolean save(DepartmentMembers departmentMembers);

    boolean delete(Long id);

    boolean update(DepartmentMembers departmentMembers);

    DepartmentMembers getById(Long id);

    List<DepartmentMembers> listByNameAndDepartmentId(String name, Long departmentId);

}
