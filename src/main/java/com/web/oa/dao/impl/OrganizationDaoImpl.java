package com.web.oa.dao.impl;

import com.web.oa.bean.Organization;
import com.web.oa.dao.OrganizationDao;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(Organization organization) {
        try {
            hibernateTemplate.save(organization);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Organization getOrgByOrgId(Long orgId) {
        return hibernateTemplate.get(Organization.class,orgId);
    }
}
