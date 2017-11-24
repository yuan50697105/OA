package com.web.oa.controller.notice;

import com.web.oa.bean.Notice;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.NoticeService;
import org.aspectj.weaver.ast.Not;
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
    @RequestMapping("/getNoticeManage")
    public String getNoticeList(String noticeType,String noticeName,Model model){
        List<Notice> noticeList=noticeService.getNoticeList(noticeType,noticeName);
        model.addAttribute("noticeList",noticeList);
        return "notice/noticeManage";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "notice/addNotice";
    }
    @RequestMapping("/ajaxAddNotice")
    @ResponseBody
    public boolean addNotice(Notice notice,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        notice.setOrgId(user.getOrgId());
        return noticeService.addNotice(notice);
    }
    @RequestMapping("/getNotice")
    public String getNotice(Long noticeId,Model model){
        Notice notice=noticeService.getNotice(noticeId);
        model.addAttribute("notice",notice);
        return "notice/noticeEdit";
    }
    @RequestMapping("/ajaxUpdateNotice")
    @ResponseBody
    public boolean ajaxUpdataNotice(Notice notice){
        return noticeService.updateNotice(notice);
    }
    @RequestMapping("/ajaxGetNoticeList")
    @ResponseBody
    public List<Notice> ajaxGetNoticeList(){
        return noticeService.getNoticeList(null,null);
    }
}
