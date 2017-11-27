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

import java.util.List;
@Repository
public class WorkDaoImpl implements WorkDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
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
    public boolean delete(Long workId) {
        try {
            hibernateTemplate.delete(getByWorkId(workId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
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

    @Override
    public Work getByWorkId(Long workId) {
        return hibernateTemplate.get(Work.class,workId);
    }

    @Override
    public List<Work> listByWorkName(String workName, Long userId) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Work.class);
        detachedCriteria.add(Restrictions.eq("userId",userId));
        if (!StringUtils.isEmpty(workName)){
            detachedCriteria.add(Restrictions.like("workName",workName, MatchMode.ANYWHERE));
        }
        boolean isEmpty=hibernateTemplate.findByCriteria(detachedCriteria).isEmpty();
        if(isEmpty){
            return null;
        }else {
            return (List<Work>) hibernateTemplate.findByCriteria(detachedCriteria);
        }
    }

    @Override
    public List<Work> listByUserId(Long userId) {
       DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Work.class);
       detachedCriteria.add(Restrictions.eq("userId",userId));
       List list=hibernateTemplate.findByCriteria(detachedCriteria);
       if(list.isEmpty()){
           return null;
       }else {
           return list;
       }
    }
}
