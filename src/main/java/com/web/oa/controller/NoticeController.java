package com.web.oa.controller;

import com.web.oa.bean.Notice;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/ajaxGetNoticeList")
    @ResponseBody
    public List<Notice> ajaxGetNoticeList() {
        return noticeService.getNoticeList();
    }

    @RequestMapping("/getNoticeList")
    public String getNoticeList(String noticeName, String noticeType, Model model) {
        List<Notice> noticeList = noticeService.getNoticeList(noticeName, noticeType);
        model.addAttribute("noticeList", noticeList);
        return "notice/noticeManage";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "notice/addNotice";
    }

    @RequestMapping("/ajaxAddNotice")
    @ResponseBody
    public boolean add(Notice notice) {
        return noticeService.save(notice);
    }

    @RequestMapping("/ajaxDeleteNotice")
    @ResponseBody
    public boolean delete(Long noticeId) {
        return noticeService.delete(noticeId);
    }

    @RequestMapping("/ajaxUpdateContracts")
    @ResponseBody
    public boolean update(Notice notice, HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        notice.setOrgId(user.getOrgId());
        notice.setUserId(user.getUserId());
        return noticeService.update(notice);
    }
}
