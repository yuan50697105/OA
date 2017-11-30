package com.web.oa.controller;

import com.web.oa.bean.Notice;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("ajaxGetNoticeList")
    @ResponseBody
    public List<Notice> ajaxGetNoticeList(HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        return noticeService.getNoticeListByOrg(user.getOrgId());
    }
    @RequestMapping("getNoticeList")
    public String getNoticeList(String noticeName, HttpSession session, Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Notice> noticeList=noticeService.getNoticeListByOrgAndNoticeName(user.getOrgId(),noticeName);
        model.addAttribute("noticeList",noticeList);
        model.addAttribute("noticeName",noticeName);
        return "notice/noticeManage";
    }
    @RequestMapping("getNotice")
    public String getNotice(Long noticeId,Model model){
        Notice notice=noticeService.getNoticeById(noticeId);
        model.addAttribute("notice",notice);
        return "notice/noticeEdit";
    }
    @RequestMapping("ajaxUpdateNotice")
    @ResponseBody
    public boolean ajaxUpdateNotice(Notice notice){
        return noticeService.update(notice);
    }
    @RequestMapping("ajaxDelNotice")
    @ResponseBody
    public boolean ajaxDelNotice(String noticeIds){
        String[] ids=noticeIds.split("-");
        Long[] longs=new Long[ids.length];
        for(int i=0;i<ids.length;i++){
            longs[i]=Long.valueOf(ids[i]);
        }
        return noticeService.delete(longs);
    }
    @RequestMapping("ajaxDelSingleNotice")
    @ResponseBody
    public boolean ajaxDelSingleNotice(Long noticeId){
        Long[] ids=new Long[]{noticeId};
        return noticeService.delete(ids);
    }
    @RequestMapping("toAddNotice")
    public String toAddNotice(){
        return "notice/addNotice";
    }
    @RequestMapping("ajaxAddNotice")
    @ResponseBody
    public boolean ajaxAddNotice(Notice notice,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        notice.setOrgId(user.getOrgId());
        notice.setUserId(user.getUserId());
        return noticeService.add(notice);
    }
}
