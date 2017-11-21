package com.web.oa.controller;

import com.web.oa.bean.User;
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
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user) {
        boolean result = userService.login(user);
        return null;
    }

    @RequestMapping("/toReg")
    public String toReg() {
        return "";
    }

    @RequestMapping("/reg")
    public String reg(User user) {
        boolean result = userService.save(user);
        return "";
    }
}
