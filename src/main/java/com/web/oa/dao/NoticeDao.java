package com.web.oa.dao;

import com.web.oa.bean.Notice;

import java.util.List;

public interface NoticeDao {
    boolean save(Notice notice);

    boolean delete(Long noticeId);

    boolean update(Notice notice);

    Notice getByNoticeId(Long noticeId);

    List<Notice> listByNoticeNameAndType(String noticeName, String noticeType);
}
