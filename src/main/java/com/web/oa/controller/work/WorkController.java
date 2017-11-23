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

    /**
     * 通过Ajax获取工作计划
     * @param session 获取session中的User
     * @return 工作计划列表
     */
    @RequestMapping("/ajaxGetWorkList")
    @ResponseBody
    public List<Work> ajaxGetWorkList(HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        return workService.list(user.getUserId());
    }

    /**
     * @param session
     * @return
     */
    @RequestMapping("/getWorkList")
    public String getWorkList(HttpSession session,Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Work> workList =workService.list(user.getUserId());
        model.addAttribute("workList",workList);
        return "work/workList";
    }
    /**
     * 查看工作一个工作计划
     * @param workId 工作计划编号
     * @param model
     * @return
     */
    @RequestMapping("/getWork")
    public String getWork(Long workId, Model model){
        Work work=workService.getWork(workId);
        model.addAttribute("work",work);
        return "work/workEdit";
    }

    /**
     * @param work
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Work work){
        return workService.update(work);
    }
    @RequestMapping("/toAddWork")
    public String toAddWork(){
        return "work/addWork";
    }

    /**
     * @param work
     * @param session
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public boolean addWork(Work work,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        work.setUserId(user.getUserId());
        return workService.save(work);
    }

    /**
     * @param workId
     * @return
     */
    @RequestMapping("/delete")
    public boolean deleteWork(Long workId){
        return workService.delete(workId);
    }
}
