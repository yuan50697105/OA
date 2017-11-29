package com.web.oa.dao.impl;

import com.web.oa.bean.Department;
import com.web.oa.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(Department department) {
        try {
            hibernateTemplate.save(department);
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
    public boolean update(Department department) {
        try {
            hibernateTemplate.update(department);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Department getById(Long id) {
        return hibernateTemplate.get(Department.class,id);
    }
}
