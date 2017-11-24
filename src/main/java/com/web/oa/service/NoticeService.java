package com.web.oa.service;

import com.web.oa.bean.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNoticeList(String noticeType, String noticeName);

    boolean addNotice(Notice notice);

    Notice getNotice(Long noticeId);

    boolean updateNotice(Notice notice);
}
