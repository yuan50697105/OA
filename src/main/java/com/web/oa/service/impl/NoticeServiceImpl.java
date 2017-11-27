package com.web.oa.service.impl;

import com.web.oa.bean.Notice;
import com.web.oa.dao.NoticeDao;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> getNoticeList() {
        return noticeDao.listByNoticeNameAndType(null, null);
    }

    @Override
    public List<Notice> getNoticeList(String noticeName, String noticeType) {
        return noticeDao.listByNoticeNameAndType(noticeName, noticeType);
    }

    @Override
    public boolean save(Notice notice) {
        return noticeDao.save(notice);
    }

    @Override
    public boolean delete(Long noticeId) {
        return noticeDao.delete(noticeId);
    }

    @Override
    public boolean update(Notice notice) {
        return noticeDao.update(notice);
    }
}
