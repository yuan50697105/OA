package com.web.oa.dao;

import com.web.oa.bean.Role;

import java.util.List;

public interface RoleId {
    boolean save(Role role);
    boolean delete(Long roleId);
    boolean update(Role role);
    Role getByRoleId(Long roleId);
    List<Role> listByName(String name);
}
