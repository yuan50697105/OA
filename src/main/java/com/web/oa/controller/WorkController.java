package com.web.oa.controller;

import com.web.oa.bean.Contacts;
import com.web.oa.bean.User;
import com.web.oa.bean.Work;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.ContactsService;
import com.web.oa.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    private WorkService workService;
    @Autowired
    private ContactsService contactsService;

    /**
     * ajax获取当前用户的工作计划列表
     * @param session
     * @return
     */
    @RequestMapping("ajaxGetWorkList")
    @ResponseBody
    public List<Work> ajaxGetWorkList(HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        return workService.getWorkListByUserId(user.getUserId());
    }

    /**
     * 获取当前登录用户工作计划列表
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("getWorkList")
    public String getWorkList(String workName,HttpSession session,Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Work> workList=workService.getWorkListByUserIdAndWorkName(user.getUserId(),workName);
        model.addAttribute("workList",workList);
        return "work/workList";
    }

    /**
     * 根据工作计划ID获取对应的工作计划
     * @param workId
     * @param model
     * @return
     */
    @RequestMapping("getWork")
    public String getWork(Long workId,Model model){
        Work work=workService.getWorkByWorkId(workId);
        model.addAttribute("work",work);
        return "work/workEdit";
    }

    /**
     * ajax更新工作计划
     * @param work
     * @return
     */
    @RequestMapping("ajaxUpdateWork")
    @ResponseBody
    public boolean ajaxUpdateWork(Work work){
        return workService.updateWork(work);
    }

    /**
     * 进入工作计划主页
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("getWorkManage")
    public String getWorkManage(HttpSession session,Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Work> workList=workService.getWorkListByUserId(user.getUserId());
        model.addAttribute("workList",workList);
        return "work/workMessage";
    }

    /**
     * 跳转到新增工作计划页面
     * @return
     */
    @RequestMapping("toAddWork")
    public String toAddWork(){
        return "work/addWork";
    }

    /**
     * ajax新增工作计划
     * @param work
     * @param session
     * @return
     */
    @RequestMapping("ajaxAddWork")
    @ResponseBody
    public boolean ajaxAddWork(Work work,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        work.setUserId(user.getUserId());
        work.setOrgId(user.getOrgId());
        return workService.saveWork(work);
    }

    /**
     * ajax删除工作计划
     * @param workId
     * @return
     */
    @RequestMapping("ajaxDelWork")
    @ResponseBody
    public boolean ajaxDelWork(Long workId){
        return workService.deleteWork(workId);
    }

    /**
     * 跳转到联系人管理界面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("getContactsManage")
    public String getContactsManage(HttpSession session,Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Contacts> contactsList=contactsService.getContactsListByUserId(user.getUserId());
        model.addAttribute("contactsList",contactsList);
        return "work/contacts";
    }

    /**
     * 获取联系人
     * @param contactsId
     * @param model
     * @return
     */
    @RequestMapping("getContacts")
    public String getContacts(Long contactsId,Model model){
        Contacts contacts=contactsService.getContactsByContactsId(contactsId);
        return "work/contactsEdit";
    }

    /**
     * ajax更新联系人
     * @param contacts
     * @return
     */
    @RequestMapping("ajaxUpdateContacts")
    @ResponseBody
    public boolean ajaxUpdateContacts(Contacts contacts){
        return contactsService.updateContacts(contacts);
    }

    /**
     * 跳转到新增联系人界面
     * @return
     */
    @RequestMapping("toAddContacts")
    public String toAddContacts(){
        return "work/addContacts";
    }

    /**
     * ajax新增联系人
     * 通过ajax实现新增数据的提交和文件上传一起完成
     * @param contacts
     * @param session
     * @return
     */
    @RequestMapping("ajaxAddContacts")
    @ResponseBody
    public boolean ajaxAddContacts(Contacts contacts,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        contacts.setUserId(user.getUserId());
        contacts.setOrgId(user.getOrgId());
        return contactsService.saveContacts(contacts);
    }

    /**
     * @param contactsId
     * @return
     */
    @RequestMapping("ajaxDelContacts")
    @ResponseBody
    public boolean ajaxDelContacts(Long contactsId){
        return contactsService.deleteContacts(contactsId);
    }

}
