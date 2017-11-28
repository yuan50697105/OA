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

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 跳转到公告添加
     * @return
     */
    @RequestMapping("toAddNotice")
    public String toAddNotice(){
        return "notice/addNotice";
    }

    /**
     * 通过ajax添加
     * @param notice
     * @param session
     * @return
     */
    @RequestMapping("ajaxAddNotice")
    @ResponseBody
    public boolean ajaxAddNotice(Notice notice, HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        notice.setUserId(user.getUserId());
        notice.setOrgId(user.getOrgId());
        return noticeService.saveNotice(notice);
    }

    /**
     * ajax删除公告
     * @param noticeId
     * @return
     */
    @RequestMapping("ajaxDelNotice")
    @ResponseBody
    public boolean ajaxDelNotice(Long noticeId){
        return noticeService.deleteNotice(noticeId);
    }

    /**
     * 通过ID获取公告
     * @param noticeId
     * @param model
     * @return
     */
    @RequestMapping("getNotice")
    public String getNotice(Long noticeId, Model model){
        Notice notice=noticeService.getNoticeByNoticeId(noticeId);
        model.addAttribute("notice",notice);
        return "notice/noticeEdit";
    }

    /**
     * 通过ajax更新公告
     * @param notice
     * @return
     */
    public boolean ajaxUpdateNotice(Notice notice){
        return noticeService.updateNotice(notice);
    }
}
