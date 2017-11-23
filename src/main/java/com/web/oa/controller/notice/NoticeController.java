package com.web.oa.controller.notice;

import com.web.oa.bean.Notice;
import com.web.oa.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    private String getNoticeManage(String noticeType, String noticeName, HttpSession session,Model model){
        List<Notice> noticeList=noticeService.getNoticeList(noticeType,noticeName);
        model.addAttribute("noticeList",noticeList);
        return "notice/noticeManage";
    }
}
