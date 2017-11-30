package com.web.oa.dao.impl;

import com.web.oa.bean.Work;
import com.web.oa.dao.WorkDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class WorkDaoImpl implements WorkDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<Work> getWorkListByUserId(Long userId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select w from Work w where w.userId=:userId";
        Query<Work> query=session.createQuery(hql,Work.class);
        query.setParameter("userId",userId);
        return query.list();
    }

    @Override
    public List<Work> getWorkListByUserIdAndWorkName(Long userId, String workName) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select w from Work w where w.userId=:userId and w.workName like concat('%',:workName,'%') ";
        Query<Work> query=session.createQuery(hql,Work.class);
        query.setParameter("userId",userId);
        query.setParameter("workName",workName);
        return query.list();
    }

    @Override
    public Work getWorkById(Long workId) {
        return hibernateTemplate.get(Work.class,workId);
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
    public boolean deleteWork(Long[] workId) {
        try {
            int count=0;
            List<Work> workList=new ArrayList<>();
            for (Long id:workId) {
                workList.add(getWorkById(id));
            }
            hibernateTemplate.deleteAll(workList);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addWork(Work work) {
        try {
            hibernateTemplate.save(work);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
