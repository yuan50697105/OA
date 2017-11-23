package com.web.oa.dao;

import com.web.oa.bean.Contracts;

import java.util.List;

public interface ContractsDao {
    List<Contracts> getByContractsByUserId(Long userId);

    boolean save(Contracts contracts);
}
