package com.web.oa.dao.impl;

import com.web.oa.bean.DepartmentMembers;
import com.web.oa.bean.User;
import com.web.oa.dao.DepartmentMemberDao;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class DepartmentMemberDaoImpl implements DepartmentMemberDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean save(DepartmentMembers departmentMembers) {
        try {
            hibernateTemplate.save(departmentMembers);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(DepartmentMembers departmentMembers) {
        try {
            hibernateTemplate.update(departmentMembers);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DepartmentMembers getById(Long id) {
        return hibernateTemplate.get(DepartmentMembers.class, id);
    }

    @Override
    public List<DepartmentMembers> listByNameAndDepartmentId(String name, Long departmentId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepartmentMembers.class);
        detachedCriteria.add(Restrictions.eq("departmentId", departmentId));
        if (!StringUtils.isEmpty(name)) {
            DetachedCriteria user = DetachedCriteria.forClass(User.class);
            user.add(Restrictions.like("userName", name, MatchMode.ANYWHERE));
            user.setProjection(Projections.property("userId"));
            detachedCriteria.add(Property.forName("userId").in(user));
        }
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
}
