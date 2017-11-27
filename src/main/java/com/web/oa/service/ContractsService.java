package com.web.oa.service;

import com.web.oa.bean.Contracts;

import java.util.List;

public interface ContractsService {
    List<Contracts> getContractsList(String contractsName, Long userId);

    boolean save(Contracts contracts);

    boolean delete(Long contractsId);

    Contracts getContracts(Long contractsId);

    boolean update(Contracts contracts);
}
