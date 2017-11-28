package com.web.oa.service.impl;

import com.web.oa.bean.Notice;
import com.web.oa.dao.NoticeDao;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public boolean saveNotice(Notice notice) {
        return noticeDao.saveNotice(notice);
    }

    @Override
    public boolean deleteNotice(Long noticeId) {
        return noticeDao.deleteNotice(noticeId);
    }



    @Override
    public Notice getNoticeByNoticeId(Long noticeId) {
        return noticeDao.getNoticeByNoticeId(noticeId);
    }

    @Override
    public boolean updateNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }
}
