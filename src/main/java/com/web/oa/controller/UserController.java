package com.web.oa.controller;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("toLogin")
    public String toLogin(){
        return "user/login";
    }
    @RequestMapping("login")
    public String login(User user,HttpSession session){
        User u= (User) session.getAttribute(WebCommons.USER);
        if (null!=u){
            return "main/main";
        }
        Map<String,Object> map=userService.login(user);
        session.setAttribute(WebCommons.USER,map.get(WebCommons.USER));
        session.setAttribute(WebCommons.ORG,map.get(WebCommons.ORG));
        session.setAttribute(WebCommons.USER_DATA,map.get(WebCommons.USER_DATA));
        session.setAttribute(WebCommons.MENU_LIST,map.get(WebCommons.MENU_LIST));
        return "main/main";
    }
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/user/toLogin";
    }
    @RequestMapping("toRegistor")
    public String toRegistor(){
        return "user/register";
    }
    @RequestMapping("registor")
    public String registor(User user, UserData userData, Organization organization, Model model){
        if(null!=organization&&!"".equals(organization.getOrgName())){
            if(null!=user&&!"".equals(user.getUserName())){
                Map<String,Object> map=userService.registor(user,userData,organization);
                if(null!=map){
                    model.addAllAttributes(map);
                    model.addAttribute(WebCommons.OP_MSG,"恭喜您注册成功！");
                }else {
                    model.addAttribute(WebCommons.OP_MSG,"注册失败！");
                }
            }
        }
        return "user/register_message";
    }
}
