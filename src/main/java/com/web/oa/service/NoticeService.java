package com.web.oa.service;

import com.web.oa.bean.Notice;

public interface NoticeService {
    boolean saveNotice(Notice notice);

    boolean deleteNotice(Long noticeId);

    Notice getNoticeByNoticeId(Long noticeId);

    boolean updateNotice(Notice notice);
}
