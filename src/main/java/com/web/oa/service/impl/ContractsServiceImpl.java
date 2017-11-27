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
    public List<Contracts> getContractsList(String contractsName, Long userId) {
        return contractsDao.listByContractsNameAndUserId(contractsName,userId);
    }

    @Override
    public boolean save(Contracts contracts) {
        return contractsDao.save(contracts);
    }

    @Override
    public boolean delete(Long contractsId) {
        return contractsDao.delete(contractsId);
    }

    @Override
    public Contracts getContracts(Long contractsId) {
        return contractsDao.getByContractsId(contractsId);
    }

    @Override
    public boolean update(Contracts contracts) {
        return contractsDao.update(contracts);
    }
}
