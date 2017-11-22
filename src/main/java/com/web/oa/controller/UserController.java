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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.windows.WEmbeddedFrame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        Map<String,Object> map=userService.login(user);
        session.setAttribute(WebCommons.USER,map.get(WebCommons.USER));
        session.setAttribute(WebCommons.ORG,map.get(WebCommons.ORG));
        session.setAttribute(WebCommons.USER_DATA,map.get(WebCommons.USER_DATA));
        return "main/main";
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/user/login";
    }
    @RequestMapping("/toRegistor")
    public String toReg(){
        return "user/register";
    }
    @RequestMapping(value = "/registor",method = RequestMethod.POST)
    public String reg(User user, Organization organization, UserData userData, Model model){
        System.out.println(organization);
        System.out.println(user);
        System.out.println(userData);
        Map map=userService.reg(user,userData,organization);
        if(null!=map){
            user= (User) map.get(WebCommons.USER);
            organization= (Organization) map.get(WebCommons.ORG);
            model.addAttribute(WebCommons.USER,user);
            model.addAttribute(WebCommons.ORG,organization);
            model.addAttribute(WebCommons.OP_MSG,"恭喜注册成功");
            return "user/register_message";
        }else {
            model.addAttribute(WebCommons.OP_MSG,"注册失败");
            return "user/register";
        }

    }

}
