package com.web.oa.controller.work;

import com.web.oa.bean.User;
import com.web.oa.bean.Work;
import com.web.oa.commons.SQLTip;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;
    @RequestMapping("/listByUseridAjax")
    @ResponseBody
    public List<Work> list(HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        return workService.list(user.getUserId());
    }
    @RequestMapping("/getWork")
    public String getWork(Long workId, Model model){
        Work work=workService.getWork(workId);
        model.addAttribute("work",work);
        return "work/workEdit";
    }
    @RequestMapping("/toSave")
    public String toSave(){
        return null;
    }
    @RequestMapping("/save")
    public String save(Work work, HttpSession session, RedirectAttributes attributes){
        User user= (User) session.getAttribute(WebCommons.USER);
        work.setUserId(user.getUserId());
        boolean flag=workService.save(work);
        attributes.addFlashAttribute(WebCommons.TIP, SQLTip.save(flag));
        return null;
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Work work){
        return workService.update(work);
    }
}
