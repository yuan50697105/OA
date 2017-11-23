package com.web.oa.dao;

import com.web.oa.bean.Role;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Role> list(String name, long startIndex, int pageSize) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Role.class);
        if(!StringUtils.isEmpty(name)){
            detachedCriteria.add(Restrictions.like("roleName",name, MatchMode.ANYWHERE));
        }
        return (List<Role>) hibernateTemplate.findByCriteria(detachedCriteria,Integer.valueOf(String.valueOf(startIndex)),pageSize);
    }

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
            hibernateTemplate.delete(hibernateTemplate.get(Role.class,id));
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
    public Long count(String name) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Role.class);
        if(!StringUtils.isEmpty(name)){
            detachedCriteria.add(Restrictions.like("roleName",name,MatchMode.ANYWHERE));
        }
        detachedCriteria.setProjection(Projections.rowCount());
        return Long.valueOf(hibernateTemplate.findByCriteria(detachedCriteria).get(0).toString());
    }
}
