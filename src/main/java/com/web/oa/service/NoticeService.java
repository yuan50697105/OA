package com.web.oa.service;

import com.web.oa.bean.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeListByOrg(Long orgId);

    List<Notice> getNoticeListByOrgAndNoticeName(Long orgId, String noticeName);

    Notice getNoticeById(Long noticeId);

    boolean update(Notice notice);

    boolean delete(Long[] longs);

    boolean add(Notice notice);
}
