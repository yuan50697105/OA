package com.web.oa.controller;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.web.oa.bean.Contacts;
import com.web.oa.bean.User;
import com.web.oa.bean.Work;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("ajaxGetWorkList")
    @ResponseBody
    public List<Work> ajaxGetWorkList(HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        return workService.getWorkListByUserId(user.getUserId());
    }
    @RequestMapping("getWorkList")
    public String getWorkList(String workName, HttpSession session, Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Work> workList=workService.getWorkListByUserIdAndWorkName(user.getUserId(),workName);
        model.addAttribute("workList",workList);
        model.addAttribute("workName",workName);
        return "work/workMessage";
    }
    @RequestMapping("getWork")
    public String getWork(Long workId,Model model){
        Work work=workService.getWorkById(workId);
        model.addAttribute("work",work);
        return "work/workEdit";
    }
    @RequestMapping("ajaxUpdateWork")
    @ResponseBody
    public boolean ajaxUpdateWork(Work work){
        return workService.updateWork(work);
    }
    @RequestMapping("ajaxDelWork")
    @ResponseBody
    public boolean ajaxDelWork(String workIds){
        String[] ids=workIds.split("-");
        Long[] longs=new Long[ids.length];
        for (int i=0;i<ids.length;i++) {
            longs[i]=Long.valueOf(ids[i]);
        }
        return workService.deleteWork(longs);
    }
    @RequestMapping("ajaxDelSingleWork")
    @ResponseBody
    public boolean ajaxDelSingleWork(Long workId){
        Long[] longs=new Long[]{workId};
        return workService.deleteWork(longs);
    }
    @RequestMapping("toAddWork")
    public String toAddWrok(){
        return "work/addWork";
    }
    @RequestMapping("ajaxAddWork")
    @ResponseBody
    public boolean ajaxAddWork(Work work,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);

        work.setUserId(user.getUserId());
        work.setOrgId(user.getOrgId());
//        System.out.println(work);
        return workService.addWork(work);
    }
    @RequestMapping("getContactList")
    public String getContactList(String contactsName, HttpSession session,Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Contacts> contactsList=workService.getContactsListByUserIdAndContactsName(user.getUserId(),contactsName);
        model.addAttribute("contactsList",contactsList);
        return "work/contactsManage";
    }
    @RequestMapping("getContacts")
    public String getContacts(Long contactsId,Model model){
        Contacts contacts=workService.getContactsById(contactsId);
        model.addAttribute("contacts",contacts);
        return "worl/contactsEdit";
    }
    @RequestMapping("ajaxUpdateContacts")
    @ResponseBody
    public boolean ajaxUpdateContacts(Contacts contacts){
        return workService.updateContacts(contacts);
    }
    @RequestMapping("ajaxDelContacts")
    @ResponseBody
    public boolean ajaxDelContacts(Long contactsId){
        return workService.deleteContacts(contactsId);
    }
    @RequestMapping("toAddContacts")
    public String toAddContacts(){
        return "work/addContacts";
    }
    @RequestMapping("ajaxAddContacts")
    @ResponseBody
    public boolean ajaxAddContacts(Contacts contacts,HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        contacts.setOrgId(user.getOrgId());
        contacts.setUserId(user.getUserId());
        return workService.addContacts(contacts);
    }

}
