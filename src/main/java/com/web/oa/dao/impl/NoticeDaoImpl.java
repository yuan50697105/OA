package com.web.oa.dao.impl;

import com.web.oa.bean.Notice;
import com.web.oa.dao.NoticeDao;
import org.aspectj.weaver.ast.Not;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
@Repository
public class NoticeDaoImpl implements NoticeDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
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

    @Override
    public boolean delete(Long noticeId) {
        try {
            hibernateTemplate.delete(getByNoticeId(noticeId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
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
    public Notice getByNoticeId(Long noticeId) {
        return hibernateTemplate.get(Notice.class,noticeId);
    }

    @Override
    public List<Notice> listByNoticeNameAndType(String noticeName,String noticeType) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Notice.class);
        if(!StringUtils.isEmpty(noticeName)){
            detachedCriteria.add(Restrictions.like("noticeName",noticeName, MatchMode.ANYWHERE));
        }
        if(!StringUtils.isEmpty(noticeType)){
            detachedCriteria.add(Restrictions.eq("noticeType",noticeType));
        }
        boolean isEmpty=hibernateTemplate.findByCriteria(detachedCriteria).isEmpty();
        if(isEmpty){
            return null;
        }else {
            return (List<Notice>) hibernateTemplate.findByCriteria(detachedCriteria);
        }
    }
}
