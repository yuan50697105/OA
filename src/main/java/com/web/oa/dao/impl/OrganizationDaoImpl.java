package com.web.oa.dao.impl;

import com.web.oa.bean.Organization;
import com.web.oa.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Organization save(Organization organization) {
        return (Organization) hibernateTemplate.save(organization);
    }
}
