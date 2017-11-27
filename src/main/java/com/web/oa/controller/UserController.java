package com.web.oa.controller;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/toRegistor")
    public String toReg(){
        return "user/register";
    }
    @RequestMapping("/registor")
    public String reg(User user, UserData userData, Organization organization, Model model){
        Map<String,Object> map=userService.registor(user,userData,organization);
        model.addAttribute(WebCommons.USER,map.get(WebCommons.USER));
        model.addAttribute(WebCommons.USER_DATA,map.get(WebCommons.USER_DATA));
        model.addAttribute(WebCommons.ORG,map.get(WebCommons.ORG));
        return "user/register_message";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        Map<String,Object> map=userService.login(user);
        if(null!=map){
            session.setAttribute(WebCommons.USER,map.get(WebCommons.USER));
            session.setAttribute(WebCommons.ORG,map.get(WebCommons.ORG));
            session.setAttribute(WebCommons.USER_DATA,map.get(WebCommons.USER_DATA));
        }
        return "main/main";
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:user/toLogin";
    }
}
