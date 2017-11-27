package com.web.oa.service;

import com.web.oa.bean.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeList();

    List<Notice> getNoticeList(String noticeName, String noticeType);

    boolean save(Notice notice);
}
