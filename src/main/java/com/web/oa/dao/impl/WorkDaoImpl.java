package com.web.oa.dao.impl;

import com.web.oa.bean.Work;
import com.web.oa.dao.WorkDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.resource.spi.work.WorkEvent;
import java.util.List;
@Repository
public class WorkDaoImpl implements WorkDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     *
     * @see WorkDao
     */
    @Override
    public List<Work> list(Long userid) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Work.class);
        if(!StringUtils.isEmpty(userid)){
            detachedCriteria.add(Restrictions.eq("userId",userid));
        }
        return (List<Work>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    /**
     * @see WorkDao
     */
    @Override
    public boolean save(Work work) {
        try {
            hibernateTemplate.save(work);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Work getById(Long id) {
        return hibernateTemplate.get(Work.class,id);
    }

    @Override
    public boolean update(Work work) {
        try {
            hibernateTemplate.update(work);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
