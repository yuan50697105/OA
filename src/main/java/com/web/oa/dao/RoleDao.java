package com.web.oa.dao;

import com.web.oa.bean.Role;

import javax.persistence.Lob;
import java.util.List;

public interface RoleDao {

    List<Role> list(String name, long startIndex, int pageSize);

    boolean save(Role role);

    boolean delete(Long id);

    Role getById(Long id);

    boolean update(Role role);

    Long count(String name);
}
