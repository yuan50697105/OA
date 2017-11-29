package com.web.oa.dao.impl;

import com.web.oa.bean.DepartmentMembers;
import com.web.oa.dao.DepartmentMembersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentMembersDaoImpl implements DepartmentMembersDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(DepartmentMembers departmentMembers) {
        try {
            hibernateTemplate.save(departmentMembers);
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
    public boolean update(DepartmentMembers departmentMembers) {
        try {
            hibernateTemplate.update(departmentMembers);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DepartmentMembers getById(Long id) {
        return hibernateTemplate.get(DepartmentMembers.class,id);
    }
}
