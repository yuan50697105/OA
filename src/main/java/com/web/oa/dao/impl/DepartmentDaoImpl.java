package com.web.oa.dao.impl;

import com.web.oa.bean.Department;
import com.web.oa.dao.DepartmentDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
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
    public boolean delete(Long departmentId) {
        try {
            hibernateTemplate.delete(getByDepartmentId(departmentId));
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
    public Department getByDepartmentId(Long departmentId) {
        return hibernateTemplate.get(Department.class,departmentId);
    }

    @Override
    public List<Department> listByDepartmentNameAndOrgId(String departmentName, Long orgId) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
        detachedCriteria.add(Restrictions.eq("orgId",orgId));
        if(!StringUtils.isEmpty(departmentName)){
            detachedCriteria.add(Restrictions.like("departmentName",departmentName, MatchMode.ANYWHERE));
        }
        List list=hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }
}
