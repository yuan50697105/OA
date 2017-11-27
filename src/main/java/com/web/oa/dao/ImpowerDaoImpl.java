package com.web.oa.dao;

import com.web.oa.bean.Impower;
import com.web.oa.bean.Role;
import com.web.oa.dao.impl.ImpowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ImpowerDaoImpl implements ImpowerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(Impower impower) {
        try {
            hibernateTemplate.save(impower);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Impower impower) {
        return false;
    }

    @Override
    public Impower getById(Long id) {
        return hibernateTemplate.get(Impower.class,id);
    }
}
