package com.web.oa.dao;

import com.web.oa.bean.Role;

public interface RoleDao {
    boolean save(Role role);
    boolean delete(Long id);
    boolean update(Role role);
    Role getById(Long id);
}
