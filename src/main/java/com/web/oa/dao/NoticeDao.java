package com.web.oa.dao;

import com.web.oa.bean.Notice;

import java.util.List;

public interface NoticeDao {

    List<Notice> getNoticeList(String noticeType, String noticeName);

    boolean save(Notice notice);

    Notice getNotice(Long noticeId);

    boolean update(Notice notice);
}
