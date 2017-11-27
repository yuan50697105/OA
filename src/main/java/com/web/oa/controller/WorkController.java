package com.web.oa.controller;

import com.web.oa.bean.User;
import com.web.oa.bean.Work;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @RequestMapping("/ajaxGetWorkList")
    @ResponseBody
    public List<Work> ajaxGetWorkList(HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        return workService.getWorkListByUserId(user.getUserId());
    }

    @RequestMapping("/getWorkList")
    public String getWorkListWorkList(String workName, HttpSession session, Model model) {
        User user = (User) session.getAttribute(WebCommons.USER);
        List<Work> workList = workService.getWorkListByName(workName, user.getUserId());
        return "work/workList";
    }

    @RequestMapping("/getWork")
    public String getWork(Long workId, Model model) {
        Work work = workService.getWork(workId);
        model.addAttribute("work", work);
        return "work/workEdit";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "";
    }

    @RequestMapping("ajaxAddWork")
    @ResponseBody
    public boolean add(Work work, HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        work.setOrgId(user.getOrgId());
        work.setUserId(user.getUserId());
        return workService.save(work);
    }

    @RequestMapping("/ajaxDeleteWork")
    @ResponseBody
    public boolean delete(Long workId) {
        return workService.delete(workId);
    }

    @RequestMapping("/ajaxUpdateWork")
    @ResponseBody
    public boolean update(Work work, HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        work.setOrgId(user.getOrgId());
        work.setUserId(user.getUserId());
        return workService.update(work);
    }
}
