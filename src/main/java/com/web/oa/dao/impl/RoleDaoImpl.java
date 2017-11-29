package com.web.oa.dao.impl;

import com.web.oa.bean.Role;
import com.web.oa.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(Role role) {
        try {
            hibernateTemplate.save(role);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Role role) {
        try {
            hibernateTemplate.update(role);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Role getById(Long id) {
        return hibernateTemplate.get(Role.class,id);
    }
}
