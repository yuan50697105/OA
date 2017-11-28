package com.web.oa.dao;

import com.web.oa.bean.Notice;

public interface NoticeDao {
    boolean saveNotice(Notice notice);

    boolean deleteNotice(Long noticeId);

    Notice getNoticeByNoticeId(Long noticeId);

    boolean updateNotice(Notice notice);
}
