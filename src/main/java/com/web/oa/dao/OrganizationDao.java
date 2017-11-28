package com.web.oa.dao;

import com.web.oa.bean.Organization;

public interface OrganizationDao {
    boolean save(Organization organization);

    Organization getOrgByOrgId(Long orgId);
}
