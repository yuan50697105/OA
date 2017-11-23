package com.web.oa.service;

import com.web.oa.bean.Role;
import com.web.oa.commons.PageModel;

public interface RoleService {

    PageModel<Role> list(String name, Integer page, int i);

    boolean save(Role role);

    boolean delete(Long id);

    Role getById(Long id);

    boolean update(Role role);
}
