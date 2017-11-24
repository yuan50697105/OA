package com.web.oa.controller.main;

import com.web.oa.bean.Menu;
import com.web.oa.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private MainService mainService;
    public String one(Long menuId, HttpSession session){
        List<Menu> menuList=mainService.getMenuListBySuperiorId(menuId);
        return "user/login";
    }
}
