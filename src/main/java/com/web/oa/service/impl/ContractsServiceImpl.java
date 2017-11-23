package com.web.oa.service.impl;

import com.web.oa.bean.Contracts;
import com.web.oa.dao.ContractsDao;
import com.web.oa.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractsServiceImpl implements ContractsService {
    @Autowired
    private ContractsDao contractsDao;

    @Override
    public List<Contracts> getContractsByUserId(Long userId) {
        return contractsDao.getByContractsByUserId(userId);
    }

    @Override
    public boolean save(Contracts contracts) {
        return contractsDao.save(contracts);
    }
}
