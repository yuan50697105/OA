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
import sun.awt.windows.WEmbeddedFrame;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/toReg")
    public String toReg(){
        return "user/register";
    }
    @RequestMapping("/reg")
    public String reg(User user, Organization organization, UserData userData, Model model){
        if(null!=organization && "".equals(organization.getOrgName())){
            if(null!=user&&!"".equals(user.getUserName())){
                Map map=userService.reg(user,userData,organization);
                if(null!=map){
                    user= (User) map.get(WebCommons.USER);
                    organization= (Organization) map.get(WebCommons.ORG);
                    model.addAttribute(WebCommons.USER,user);
                    model.addAttribute(WebCommons.ORG,organization);
                    model.addAttribute(WebCommons.OP_MSG,"恭喜注册成功");
                    return "user/reg_msg";
                }else {
                    model.addAttribute(WebCommons.OP_MSG,"注册失败");

                }
            }
        }
        return "user/register";
    }
    public String login(User user){
        return "";
    }
}
