package com.web.oa.dao;

import com.web.oa.bean.Organization;

public interface OrgDao {
    boolean save(Organization organization);

    Organization getOrgById(Long orgId);
}
