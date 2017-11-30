package com.web.oa.service.impl;

import com.web.oa.bean.Notice;
import com.web.oa.dao.NoticeDao;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> getNoticeListByOrg(Long orgId) {
        return noticeDao.getNoticeListByOrg(orgId);
    }

    @Override
    public List<Notice> getNoticeListByOrgAndNoticeName(Long orgId, String noticeName) {
        if (StringUtils.isEmpty(noticeName)){
            return noticeDao.getNoticeListByOrg(orgId);
        }else {
            return noticeDao.getNoticeListByOrgAndNoticeName(orgId,noticeName);
        }
    }

    @Override
    public Notice getNoticeById(Long noticeId) {
        return noticeDao.getNoticeById(noticeId);
    }

    @Override
    public boolean update(Notice notice) {
        return noticeDao.update(notice);
    }

    @Override
    public boolean delete(Long[] longs) {
        return noticeDao.delete(longs);
    }

    @Override
    public boolean add(Notice notice) {
        return noticeDao.save(notice);
    }
}
