package com.web.oa.controller;

import com.web.oa.bean.Organization;
import com.web.oa.bean.User;
import com.web.oa.bean.UserData;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/views/login";
    }
    @RequestMapping("/toReg")
    public String toReg(){
        return "/views/register";
    }
    @RequestMapping("/reg")
    public String reg(User user, UserData userData, Organization organization){
        boolean flag=userService.save(user,userData,organization);
        return null;
    }
}
