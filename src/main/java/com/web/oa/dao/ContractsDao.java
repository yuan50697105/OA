package com.web.oa.dao;

import com.web.oa.bean.Contracts;

import java.util.List;

public interface ContractsDao {
    boolean save(Contracts contracts);
    boolean delete(Long contractsId);
    boolean update(Contracts contracts);
    Contracts getByContractsId(Long contractsId);
    List<Contracts> listByContractsNameAndUserId(String contractsName,Long userId);
}
