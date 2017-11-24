package com.web.oa.service.impl;

import com.web.oa.bean.Notice;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.oa.dao.NoticeDao;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> getNoticeList(String noticeType, String noticeName) {
        return noticeDao.getNoticeList(noticeType,noticeName);
    }

    @Override
    public boolean addNotice(Notice notice) {
        return noticeDao.save(notice);
    }

    @Override
    public Notice getNotice(Long noticeId) {
        return noticeDao.getNotice(noticeId);
    }

    @Override
    public boolean updateNotice(Notice notice) {
        return noticeDao.update(notice);
    }
}
