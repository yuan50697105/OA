package com.web.oa.dao.impl;

import com.web.oa.bean.Contracts;
import com.web.oa.dao.ContractsDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
@Repository
public class ContractsDaoImpl implements ContractsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(Contracts contracts) {
        try {
            hibernateTemplate.save(contracts);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long contractsId) {
        try {
            hibernateTemplate.delete(getByContractsId(contractsId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Contracts contracts) {
        try {
            hibernateTemplate.update(contracts);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Contracts getByContractsId(Long contractsId) {
        return hibernateTemplate.get(Contracts.class,contractsId);
    }

    @Override
    public List<Contracts> listByContractsNameAndUserId(String contractsName, Long userId) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Contracts.class);
        detachedCriteria.add(Restrictions.eq("userId",userId));
        if(!StringUtils.isEmpty(contractsName)){
            detachedCriteria.add(Restrictions.like("name",contractsName, MatchMode.ANYWHERE));
        }
        List list=hibernateTemplate.findByCriteria(detachedCriteria);
        if(list.isEmpty()){
            return null;
        }else {
            return list;
        }
    }
}
