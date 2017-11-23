package com.web.oa.service;

import com.web.oa.bean.Contracts;

import java.util.List;

public interface ContractsService {
    List<Contracts> getContractsByUserId(Long userId);

    boolean save(Contracts contracts);
}
