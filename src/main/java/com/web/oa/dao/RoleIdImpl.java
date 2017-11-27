package com.web.oa.dao;

import com.web.oa.bean.Role;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
@Repository
public class RoleIdImpl implements RoleId {
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
    public boolean delete(Long roleId) {
        try {
            hibernateTemplate.delete(getByRoleId(roleId));
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
    public Role getByRoleId(Long roleId) {
        return hibernateTemplate.get(Role.class,roleId);
    }

    @Override
    public List<Role> listByName(String name) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Role.class);
        if(!StringUtils.isEmpty(name)){
            detachedCriteria.add(Restrictions.like("roleName",name, MatchMode.ANYWHERE));
        }
        List list=hibernateTemplate.findByCriteria(detachedCriteria);
        if(list.isEmpty()){
            return null;
        }else {
            return list;
        }
    }
}
