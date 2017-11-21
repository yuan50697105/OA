package com.web.oa.dao.impl;

import com.web.oa.bean.Department;
import com.web.oa.dao.DepartmentDao;
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
    public boolean delete(long id) {
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
    public Department getById(long id) {
        return hibernateTemplate.get(Department.class,id);
    }

    @Override
    public List<Department> findAll() {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(DetachedCriteria.class);
        return (List<Department>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public List<Department> findByDepartmentName(String departmentName) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
        if (!StringUtils.isEmpty(departmentName)){
            detachedCriteria.add(Restrictions.like("departmentName",departmentName, MatchMode.ANYWHERE));
        }
        return (List<Department>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public List<Department> findByDepartmentName(String departmentName, int page, int size) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
        if (!StringUtils.isEmpty(departmentName)){
            detachedCriteria.add(Restrictions.like("departmentName",departmentName, MatchMode.ANYWHERE));
        }
        return (List<Department>) hibernateTemplate.findByCriteria(detachedCriteria,page,size);
    }

    @Override
    public Long countByDepartmentName(String departmentName) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
        if (!StringUtils.isEmpty(departmentName)){
            detachedCriteria.add(Restrictions.like("departmentName",departmentName, MatchMode.ANYWHERE));
        }
        detachedCriteria.setProjection(Projections.rowCount());
        return (Long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
    }


}
