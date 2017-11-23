package com.web.oa.dao.impl;

import com.web.oa.bean.Contracts;
import com.web.oa.dao.ContractsDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractsDaoImpl implements ContractsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Contracts> getByContractsByUserId(Long userId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select c from Contracts c where c.userId=:userid";
        Query<Contracts> query=session.createQuery(hql,Contracts.class);
        query.setParameter("userid",userId);
        return query.list();
    }

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
}
