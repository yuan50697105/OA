package com.web.oa.controller.main;

import com.web.oa.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private MainService mainService;
    @RequestMapping("/content")
    public String content(String url, Model data){
        data.addAttribute("url",url);
        return "main/content";
    }
}
