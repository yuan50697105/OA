package com.web.oa.dao.impl;

import com.web.oa.bean.Notice;
import com.web.oa.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDaoImpl implements NoticeDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean saveNotice(Notice notice) {
        try {
            hibernateTemplate.save(notice);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteNotice(Long noticeId) {
        try {
            hibernateTemplate.delete(hibernateTemplate.get(Notice.class,noticeId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Notice getNoticeByNoticeId(Long noticeId) {
        return hibernateTemplate.get(Notice.class,noticeId);
    }

    @Override
    public boolean updateNotice(Notice notice) {
        try {
            hibernateTemplate.update(notice);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
