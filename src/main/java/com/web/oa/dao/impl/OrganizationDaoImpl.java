package com.web.oa.dao.impl;

import com.web.oa.bean.Organization;
import com.web.oa.dao.OrganizationDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean save(Organization organization) {
        try {
            hibernateTemplate.save(organization);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long orgId) {
        try {
            hibernateTemplate.delete(getByOrgId(orgId));
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Organization organization) {
        try {
            hibernateTemplate.update(organization);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Organization getByOrgId(Long orgId) {
        return hibernateTemplate.get(Organization.class, orgId);
    }

    @Override
    public List<Organization> listByOrgName(String orgName) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Organization.class);
        if (!StringUtils.isEmpty(orgName)) {
            detachedCriteria.add(Restrictions.like("orgName", orgName, MatchMode.ANYWHERE));
        }
        boolean isEmpty = hibernateTemplate.findByCriteria(detachedCriteria).isEmpty();
        if (isEmpty) {
            return null;
        } else {
            return (List<Organization>) hibernateTemplate.findByCriteria(detachedCriteria);
        }
    }
}
