package com.web.oa.service.impl;

import com.web.oa.bean.Role;
import com.web.oa.dao.RoleDao;
import com.web.oa.service.RoleService;
import com.web.oa.commons.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public PageModel<Role> list(String name, Integer page, int i) {
        PageModel<Role> pageModel=new PageModel<>();
        pageModel.setPageIndex(page);
        pageModel.setPageSize(i);;
        List<Role> list=roleDao.list(name,pageModel.getStartIndex(),pageModel.getPageSize());
        Long count=roleDao.count(name);
        return pageModel;
    }

    @Override
    public boolean save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public boolean delete(Long id) {
        return roleDao.delete(id);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public boolean update(Role role) {
        return roleDao.update(role);
    }
}
