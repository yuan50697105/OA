package com.web.oa.dao.impl;

import com.web.oa.bean.Notice;
import com.web.oa.dao.NoticeDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoticeDaoImpl implements NoticeDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Notice> getNoticeListByOrg(Long orgId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select n from Notice n where n.orgId=:orgId";
        Query<Notice> query=session.createQuery(hql,Notice.class);
        query.setParameter("orgId",orgId);
        return query.list();
    }

    @Override
    public List<Notice> getNoticeListByOrgAndNoticeName(Long orgId, String noticeName) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select n from Notice n where n.orgId=:orgId and n.noticeName like concat('%',:noticeName,'%') ";
        Query<Notice> query=session.createQuery(hql,Notice.class);
        query.setParameter("orgId",orgId);
        query.setParameter("noticeName",noticeName);
        return query.list();
    }

    @Override
    public Notice getNoticeById(Long noticeId) {
        return hibernateTemplate.get(Notice.class,noticeId);
    }

    @Override
    public boolean update(Notice notice) {
        try {
            hibernateTemplate.update(notice);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long[] longs) {
        try {
            List<Notice> noticeList=new ArrayList<>();
            for (Long id:longs) {
                noticeList.add(getNoticeById(id));
            }
            hibernateTemplate.deleteAll(noticeList);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(Notice notice) {
        try {
            hibernateTemplate.save(notice);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
