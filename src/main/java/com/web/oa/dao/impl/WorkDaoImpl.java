package com.web.oa.dao.impl;

import com.web.oa.bean.Work;
import com.web.oa.dao.WorkDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class WorkDaoImpl implements WorkDao {
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Work> getWorkListByUserId(Long userId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Work.class);
        detachedCriteria.add(Restrictions.eq("userId", userId));
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }

    @Override
    public Work getWorkByWorkId(Long workId) {
        return hibernateTemplate.get(Work.class,workId);
    }

    @Override
    public boolean updateWork(Work work) {
        try {
            hibernateTemplate.update(work);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

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
    public boolean deleteWork(Long workId) {
        try {
            Work work=new Work();
            work.setWorkId(workId);
            hibernateTemplate.delete(work);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Work> getWorkListByUserIdAndWorkName(Long userId, String workName) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Work.class);
        detachedCriteria.add(Restrictions.eq("userId", userId));
        if (!StringUtils.isEmpty(workName)) {
            detachedCriteria.add(Restrictions.like("workName", workName, MatchMode.ANYWHERE));
        }
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }
}
