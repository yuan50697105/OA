package com.web.oa.dao;

import com.web.oa.bean.Organization;

import java.util.List;

public interface OrganizationDao {
    boolean save(Organization organization);

    boolean delete(Long orgId);

    boolean update(Organization organization);

    Organization getByOrgId(Long orgId);

    List<Organization> listByOrgName(String orgName);

}
